package com.stream.video.repositories;

import com.stream.video.models.Videos;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<@NonNull Videos, @NonNull UUID>{
    @Modifying
    @Query("UPDATE Videos v SET v.filename = COALESCE(:fieldName, v.filename) WHERE v.id = :video_id")
    void updateParseFields(
            String video_id,
            String fieldName
    );
}

