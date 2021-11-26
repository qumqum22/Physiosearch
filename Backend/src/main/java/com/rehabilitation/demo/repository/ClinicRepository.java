package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Clinic;
import com.rehabilitation.demo.models.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
    List<Clinic> findAllByUserdata(UserData userData);
}
