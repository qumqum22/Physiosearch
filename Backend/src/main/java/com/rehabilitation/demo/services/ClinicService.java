package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.ClinicRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;
    private final UserDataRepository userDataRepository;

    public ClinicService(ClinicRepository clinicRepository,
                         UserDataRepository userDataRepository) {
        this.clinicRepository = clinicRepository;
        this.userDataRepository = userDataRepository;
    }
    public Clinic getSingleClinic(long id) {
        return clinicRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Clinic> getClinics(UserData userData) {
        return clinicRepository.findAllByUserdata(userData);
    }

    public void deleteClinic(long user_id, Clinic clinicToRemove) {
        UserData userData = userDataRepository.findUserDataById(user_id);
        userData.removeClinic(clinicToRemove);
        userDataRepository.save(userData);
    }
    public void addClinic(Clinic clinic) {
        clinicRepository.save(clinic);
    }


}
