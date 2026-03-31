package com.stream.video.repositories;

import com.stream.video.models.Videos;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoRepository extends JpaRepository<@NonNull Videos, @NonNull UUID>{}

