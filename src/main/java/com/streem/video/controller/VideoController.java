package com.streem.video.controller;

import com.streem.video.services.VideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService vs) {
        this.videoService = vs;
    }

    @GetMapping
    public String getVideos(MultipartFile file) {
        this.videoService.processVideo();
        return "List of videos";
    }

}