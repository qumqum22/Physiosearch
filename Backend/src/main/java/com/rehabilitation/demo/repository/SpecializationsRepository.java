package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Specializations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationsRepository extends JpaRepository<Specializations, Long> {
}
