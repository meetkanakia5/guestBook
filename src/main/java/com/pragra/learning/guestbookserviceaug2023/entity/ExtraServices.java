package com.pragra.learning.guestbookserviceaug2023.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "extra_services")
@AllArgsConstructor
@NoArgsConstructor

public class ExtraServices {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long serviceId;
    private String service;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "extraServices")
    private List<GuestEntity> guest;
}
