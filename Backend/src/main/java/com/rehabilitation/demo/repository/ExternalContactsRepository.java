package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.ExternalContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalContactsRepository extends JpaRepository<ExternalContacts, Long> {
}
