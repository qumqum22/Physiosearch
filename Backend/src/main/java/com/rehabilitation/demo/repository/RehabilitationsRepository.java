package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Rehabilitations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RehabilitationsRepository extends JpaRepository<Rehabilitations, Long> {
}
