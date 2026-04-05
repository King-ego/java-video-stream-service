package com.stream.video.services;

import com.stream.video.models.Videos;
import com.stream.video.repositories.VideoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Videos upload(MultipartFile file) throws Exception {
        Videos video = Videos.builder()
                .title(file.getOriginalFilename())
                .description(file.getOriginalFilename())
                .filename(file.getOriginalFilename())
                .contentType(file.getContentType())
                .size(BigInteger.valueOf(file.getSize()))
                .build();

        return this.videoRepository.save(video);
    }

    public List<Videos> listAll() {
        return this.videoRepository.findAll();
    }

    public void updateVideoParse(String videoId, String newFilename) {
        this.videoRepository.updateParseFields(videoId, newFilename);
    }
}