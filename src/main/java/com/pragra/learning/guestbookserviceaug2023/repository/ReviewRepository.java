package com.pragra.learning.guestbookserviceaug2023.repository;

import com.pragra.learning.guestbookserviceaug2023.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
