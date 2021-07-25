package com.rehabilitation.demo.services;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.UserData;
import com.rehabilitation.demo.repository.AddressRepository;
import com.rehabilitation.demo.repository.UserDataRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserDataRepository userDataRepository;

    public AddressService(AddressRepository addressRepository,
                          UserDataRepository userDataRepository) {
        this.addressRepository = addressRepository;
        this.userDataRepository = userDataRepository;
    }
    public Address getSingleAddress(long id) {
        return addressRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<Address> getAddresses(UserData userData) {
        return addressRepository.findAllByUserdata(userData);
    }

    public void deleteAddress(long user_id, Address addressToRemove) {
        UserData userData = userDataRepository.findUserDataById(user_id);
        userData.removeAddress(addressToRemove);
        userDataRepository.save(userData);
    }
    public void addAddress(Address address) {
        addressRepository.save(address);
    }


}
