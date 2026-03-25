package com.stream.video.services;

import com.stream.video.models.Videos;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Service
public class VideoService {
    public Videos upload(MultipartFile file) throws Exception {
        Videos video = new Videos();
        video.setId(UUID.randomUUID());
        video.setTitle(file.getOriginalFilename());
        video.setFilename(file.getOriginalFilename());
        video.setContentType(file.getContentType());
        video.setSize(BigInteger.valueOf(file.getSize()));

        return videoRepository.save(video);
    }

    public List<Videos> listAll() {
        return videoRepository.findAll();
    }
}
