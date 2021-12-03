package com.rehabilitation.demo.controllers;

import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.Rehabilitations;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.RegisterUserAccountRequest;
import com.rehabilitation.demo.payload.UpdateUserRequest;
import com.rehabilitation.demo.payload.UserDataRequest;
import com.rehabilitation.demo.services.ClinicService;
import com.rehabilitation.demo.services.RehabilitationsService;
import com.rehabilitation.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class UserController {


    private final UserService userService;
    private final ClinicService clinicService;
    private final RehabilitationsService rehabilitationsService;

    // UserAccount's actions.
    @GetMapping("/users")
    public List<UserData> all()
    {
        return userService.getUsers();
     }


     @GetMapping("/users/{id}")
     public UserDataRequest getSingleUser(@PathVariable("id") long id){
        UserData userData = userService.getSingleUser(id);
         return new UserDataRequest(
                userData.getId(),
                userData.getTitle(),
                userData.getName(),
                userData.getSurname(),
                userData.getGender(),
                userData.getBirthday(),
                userData.getProfileImage(),
                userData.getDescription(),
                userData.getPhysioID()
                );
     }

     @GetMapping("/users/clinic/{id}")
     public List<UserData> getUsersByClinic(@PathVariable("id") long id) {
         Clinic tempClinic = clinicService.getSingleClinic(id);
         return userService.getUsersByClinic(tempClinic);}


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/registerUser")
    public boolean newUser(@RequestBody RegisterUserAccountRequest registerUserRequest)
    {
        return userService.save(registerUserRequest, false);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/registerPhysio")
    public boolean newPhysio(@RequestBody RegisterUserAccountRequest registerUserRequest)
    {
        return userService.save(registerUserRequest, true);
    }

    @PutMapping("/users/update/{id}")
    public boolean changeData(@PathVariable("id") long id, @RequestBody UpdateUserRequest updateUserRequest)
    {
        return userService.updateProfile(id,updateUserRequest);
    }

    @DeleteMapping("settings/delete/{id}")
    public void deleteUser(@PathVariable("id") long id)
    {
        userService.deleteUser(id);
    }

    // Rehabilitations actions.
    @GetMapping("/rehabilitations")
    public List<Rehabilitations> allRehabilitations() {
        return rehabilitationsService.getSpecializations();
    }


}
