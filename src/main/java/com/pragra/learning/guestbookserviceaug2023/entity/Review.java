package com.pragra.learning.guestbookserviceaug2023.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    private String review;
    private Integer rating;



    @Builder.Default
    private Instant dateTime = Instant.now();
}
