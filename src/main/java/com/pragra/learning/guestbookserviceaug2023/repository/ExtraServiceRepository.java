package com.pragra.learning.guestbookserviceaug2023.repository;

import com.pragra.learning.guestbookserviceaug2023.entity.ExtraServices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtraServiceRepository extends JpaRepository<ExtraServices, Long> {
}
