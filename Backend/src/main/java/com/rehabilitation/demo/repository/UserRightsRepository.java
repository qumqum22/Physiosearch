package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.UserRights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRightsRepository extends JpaRepository<UserRights, Long> {

}
