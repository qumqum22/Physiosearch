package com.rehabilitation.demo.controllers;

import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.payload.AddPhoneRequest;
import com.rehabilitation.demo.services.PhonesService;
import com.rehabilitation.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class PhonesController {

    private final PhonesService phonesService;
    private final UserService userService;
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
}
