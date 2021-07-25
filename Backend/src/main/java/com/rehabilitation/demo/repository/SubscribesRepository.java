package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Subscribes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribesRepository extends JpaRepository<Subscribes, Long> {
}
