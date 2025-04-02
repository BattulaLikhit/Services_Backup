package com.example.VidService.Service;


import java.util.List;

import com.example.VidService.Model.Video;

public interface VideoService {
    List<Video> getAllVideos();
    Video getVideoById(Long id);
    Video createVideo(Video video);
    Video updateVideo(Long id, Video video);
    void deleteVideo(Long id);
}
