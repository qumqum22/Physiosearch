package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.UserAccount;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.models.UserRights;
import com.rehabilitation.demo.payload.RegisterUserAccountRequest;
import com.rehabilitation.demo.payload.UpdateUserRequest;
import com.rehabilitation.demo.repository.UserAccountRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import com.rehabilitation.demo.repository.UserRightsRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserDataRepository userDataRepository;
    private final UserAccountRepository userAccountRepository;
    private final UserRightsRepository userRightsRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserData> getUsers() {
        return userDataRepository.findAll();
    }

    public List<UserData> getUsersByClinic(Clinic clinic) {
        return userDataRepository.findAllByClinics(clinic);}

    public UserData getSingleUser(long id) {
        return userDataRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public boolean save(RegisterUserAccountRequest registerUserAccountRequest, boolean isPhysio) {

        String userName = registerUserAccountRequest.getName();
        String gender = (userName.endsWith("a")) ? "Female" : "Male";
        UserData newUserData = new UserData(
                "",
                registerUserAccountRequest.getName(),
                registerUserAccountRequest.getSurname(),
                gender,
                null,
                null,
                "Default description",
                registerUserAccountRequest.getPhysioId());

        UserAccount userAccount = new UserAccount(
                registerUserAccountRequest.getEmail(),
                registerUserAccountRequest.getPassword(),
                newUserData);

        UserRights userUser = userRightsRepository.findByAccessRights("USER");
        newUserData.getRights().add(userUser);
        if (isPhysio){
            UserRights userPhysio = userRightsRepository.findByAccessRights("PHYSIO");
            newUserData.getRights().add(userPhysio);
        }
        this.userDataRepository.save(newUserData);
        this.userAccountRepository.save(userAccount);
        return true;
    }


    public boolean updateProfile(long id, UpdateUserRequest oldUserData) {
        UserData updatedUser = userDataRepository.findUserDataById(id);
        updatedUser.setName(oldUserData.getName());
        updatedUser.setSurname(oldUserData.getSurname());
        //updatedUser.setProfileImage(oldUserData.getProfileImage());
        updatedUser.setTitle(oldUserData.getTitle());
        updatedUser.setDescription(oldUserData.getDescription());
        // updatedUser.setAge(oldUserData.getAge());
        //updatedUser.setGender(oldUserData.getGender());
        userDataRepository.save(updatedUser);
    return true;
    }

    public void deleteUser(long id) {
        userDataRepository.deleteById(id);
    }


}
