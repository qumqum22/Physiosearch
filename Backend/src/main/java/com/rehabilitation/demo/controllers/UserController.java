package com.rehabilitation.demo.controllers;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.AddPhoneRequest;
import com.rehabilitation.demo.payload.RegisterUserAccountRequest;
import com.rehabilitation.demo.payload.UpdateUserRequest;
import com.rehabilitation.demo.payload.UserDataRequest;
import com.rehabilitation.demo.services.AddressService;
import com.rehabilitation.demo.services.PhonesService;
import com.rehabilitation.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {


    private final UserService userService;
    private final PhonesService phonesService;
    private final AddressService addressService;


    public UserController(UserService userService,
                          PhonesService phonesService,
                          AddressService addressService) {
        this.userService = userService;
        this.phonesService = phonesService;
        this.addressService = addressService;
    }

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

     @GetMapping("/users/address/{id}")
     public List<UserData> getUsersByAddress(@PathVariable("id") long id) {
         Address tempAddress = addressService.getSingleAddress(id);
         return userService.getUsersByAddress(tempAddress);}


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


    // UserAccount's phones actions.

    @GetMapping("/phones/{user_id}")
    public List<Phones> allPhones(@PathVariable("user_id") long user_id) {
        UserData tempUser = userService.getSingleUser(user_id);
        return phonesService.getPhones(tempUser);
    }

    @DeleteMapping("phones/delete/{id}")
    public void deletePhone(@PathVariable("id") long id)
    {
        phonesService.deletePhone(id);
    }

    @PostMapping("/phones/add")
    public void addPhone(@RequestBody AddPhoneRequest addPhoneRequest)
    {
        System.out.println(addPhoneRequest.getId() + " " +addPhoneRequest.getPhoneNumber());
        UserData user = userService.getSingleUser(addPhoneRequest.getId());
        System.out.println(user);
        Phones phone = new Phones(addPhoneRequest.getPhoneNumber(), user);
        System.out.println(phone);
        phonesService.addPhone(phone);
    }

    // UserAccount's addresses actions.
    @GetMapping("/address/{id}")
    public Address getSingleAddress(@PathVariable("id") long id){
        return addressService.getSingleAddress(id);
    }

    @GetMapping("/addresses/{user_id}")
    public List<Address> allAddresses(@PathVariable("user_id") long user_id) {
        UserData tempUser = userService.getSingleUser(user_id);
        //UserData addedUsers = addressService
        return addressService.getAddresses(tempUser);
    }
    @DeleteMapping("address/delete/{id}/{user_id}")
    public void deleteAddress(@PathVariable("id") long id, @PathVariable("user_id") long user_id)
    {
        System.out.println(id + " " + user_id);
        Address addressToRemove = addressService.getSingleAddress(id);
        addressService.deleteAddress(user_id, addressToRemove);
    }
}
