package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}
