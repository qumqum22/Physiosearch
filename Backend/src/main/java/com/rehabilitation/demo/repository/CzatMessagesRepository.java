package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.CzatMessages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CzatMessagesRepository extends JpaRepository<CzatMessages, Long> {
}
