package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Phones;
import com.rehabilitation.demo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long> {

    Phones findPhonesByPhoneNumber(String number);
    List<Phones> findAllByUserdata(UserData userData);
}
