package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Address;
import com.rehabilitation.demo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    UserData findUserDataById(Long id);

    List<UserData> findAllByAddress(Address address);

    void deleteAddressById(long id);
}
