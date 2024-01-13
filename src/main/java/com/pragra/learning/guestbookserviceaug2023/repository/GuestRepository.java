package com.pragra.learning.guestbookserviceaug2023.repository;

import com.pragra.learning.guestbookserviceaug2023.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity,Integer> {
    public GuestEntity findGuestEntitiesByGuestId(int id);
    public GuestEntity findGuestEntitiesByName(String name);
}
