package com.pragra.learning.guestbookserviceaug2023.repository;

import com.pragra.learning.guestbookserviceaug2023.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestAddressRepository extends JpaRepository<Address, Long> {
}
