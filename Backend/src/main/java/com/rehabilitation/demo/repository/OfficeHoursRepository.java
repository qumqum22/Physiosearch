package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.OfficeHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeHoursRepository extends JpaRepository<OfficeHours, Long> {
}
