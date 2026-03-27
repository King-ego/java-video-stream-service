package com.stream.video.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "videos")
@Data
@Builder
@AllArgsConstructor
public class Videos {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private String filename;
    private String driveFileId;
    private String contentType;
    private BigInteger size;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Videos() {}

    @PrePersist
    protected void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
