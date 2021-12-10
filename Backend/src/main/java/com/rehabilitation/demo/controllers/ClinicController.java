package com.rehabilitation.demo.controllers;


import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.services.ClinicService;
import com.rehabilitation.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;
    private final UserService userService;

    // UserAccount's clinics actions.
    @GetMapping("/clinic/{id}")
    public Clinic getSingleClinic(@PathVariable("id") long id) {
        return clinicService.getSingleClinic(id);
    }

    @GetMapping("/clinics/{user_id}")
    public List<Clinic> allClinics(@PathVariable("user_id") long user_id) {
        UserData tempUser = userService.getSingleUser(user_id);
        //UserData addedUsers = clinicService
        return clinicService.getClinics(tempUser);
    }

    @DeleteMapping("clinic/delete/{id}/{user_id}")
    public void deleteClinic(@PathVariable("id") long id, @PathVariable("user_id") long user_id) {
        System.out.println(id + " " + user_id);
        Clinic clinicToRemove = clinicService.getSingleClinic(id);
        clinicService.deleteClinic(user_id, clinicToRemove);
    }
}
