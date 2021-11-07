package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.UserAccount;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.RegisterUserAccountRequest;
import com.rehabilitation.demo.payload.UpdateUserRequest;
import com.rehabilitation.demo.repository.UserAccountRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserDataRepository userDataRepository;
    private final UserAccountRepository userAccountRepository;

    public UserService(UserDataRepository userDataRepository, UserAccountRepository userAccountRepository) {
        this.userDataRepository = userDataRepository;
        this.userAccountRepository = userAccountRepository;
    }


    public List<UserData> getUsers() {
        return userDataRepository.findAll();
    }

    public List<UserData> getUsersByAddress(Address address) {
        return userDataRepository.findAllByAddress(address);}

    public UserData getSingleUser(long id) {
        return userDataRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public boolean save(RegisterUserAccountRequest registerUserAccountRequest) {
        if(!registerUserAccountRequest.getEmail().contains("@"))
            return false;
        if(!registerUserAccountRequest.getEmail().contains("."))
            return false;
        if(registerUserAccountRequest.getPassword().length() < 6) {
            return false;
        }
        UserData newUserData = new UserData(
                "",
                registerUserAccountRequest.getName(),
                registerUserAccountRequest.getSurname(),
                null,
                null,
                null,
                "Default description");

        UserAccount userAccount = new UserAccount(
                registerUserAccountRequest.getEmail(),
                registerUserAccountRequest.getPassword(),
                "salt",
                "seed",
                newUserData);

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
