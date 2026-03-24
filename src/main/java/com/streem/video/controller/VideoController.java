package com.streem.video.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
class VideoController {

    @GetMapping
    public String getVideos(MultipartFile file) {
        return "List of videos";
    }

}