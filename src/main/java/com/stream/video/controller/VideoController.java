package com.stream.video.controller;

import com.stream.video.models.Videos;
import com.stream.video.services.VideoService;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService vs) {
        this.videoService = vs;
    }

    @GetMapping
    public ResponseEntity<@NonNull List<Videos>> getVideos() {
        return ResponseEntity.ok(videoService.listAll());
    }

    @PostMapping
    public ResponseEntity< @NonNull Videos> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            Videos video = videoService.upload(file);
            return ResponseEntity.ok(video);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}