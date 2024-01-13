package com.pragra.learning.guestbookserviceaug2023.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;


@Data
@Entity
@Table(name = "guests")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int guestId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address guestAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> review;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "guest_services",
                joinColumns = { @JoinColumn(name = "guest_id", referencedColumnName = "guestId") },
                inverseJoinColumns = { @JoinColumn(name = "extra_services", referencedColumnName = "serviceId") }
    )
    private List<ExtraServices> extraServices;

    @Transient // this won't be sent in json. It won't be sent to UI. Only use for internal business logic
    @Builder.Default
    private Instant dateTime = Instant.now();
}
