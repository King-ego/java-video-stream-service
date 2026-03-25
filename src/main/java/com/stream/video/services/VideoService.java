package com.stream.video.services;

import com.stream.video.models.Videos;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class VideoService {
    public Videos upload(MultipartFile file) throws Exception {

        // 1. Upload pro Drive
        File fileMetadata = new File();
        fileMetadata.setName(file.getOriginalFilename());

        InputStreamContent mediaContent =
                new InputStreamContent(file.getContentType(), file.getInputStream());

        File uploaded = driveService.files()
                .create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();

        // 2. Salva no banco
        Videos video = new Videos();
        video.setId(UUID.randomUUID());
        video.setTitle(file.getOriginalFilename());
        video.setFilename(file.getOriginalFilename());
        video.setDriveFileId(uploaded.getId());
        video.setContentType(file.getContentType());
        video.setSize(file.getSize());

        return videoRepository.save(video);
    }
}
