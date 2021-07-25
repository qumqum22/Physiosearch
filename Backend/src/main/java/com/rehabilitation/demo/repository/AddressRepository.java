package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUserdata(UserData userData);
}
