package com.rehabilitation.demo.repository;

import com.rehabilitation.demo.models.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long>  {

}
