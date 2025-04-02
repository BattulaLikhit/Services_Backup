package com.example.VidService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.VidService.Model.Video;

@Repository
public interface VideoRepo extends JpaRepository<Video, Long>{
     
}
