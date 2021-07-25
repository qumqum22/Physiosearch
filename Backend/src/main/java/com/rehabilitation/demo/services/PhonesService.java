package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.PhonesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonesService {

    private final PhonesRepository phonesRepository;

    public PhonesService(PhonesRepository phonesRepository)
    {
        this.phonesRepository = phonesRepository;
    }

    public List<Phones> getPhones(UserData userData) {
        return phonesRepository.findAllByUserdata(userData);
    }
    public void deletePhone(long id) {
        phonesRepository.deleteById(id);
    }
    public void addPhone(Phones phone) {
        if(phonesRepository.findPhonesByPhoneNumber(phone.getPhoneNumber())== null
                && phone.getPhoneNumber().length() >= 6
                && phone.getPhoneNumber().length() <= 12)
            phonesRepository.save(phone);
    }
}
