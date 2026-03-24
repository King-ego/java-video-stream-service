package com.stream.video.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "videos")
public class Videos {
    @Id
    @GeneratedValue
    UUID id;
    String title;
    String description;
}
