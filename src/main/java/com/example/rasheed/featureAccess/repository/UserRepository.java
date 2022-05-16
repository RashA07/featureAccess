package com.example.rasheed.featureAccess.repository;

import com.example.rasheed.featureAccess.entity.Feature;
import com.example.rasheed.featureAccess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // custom find method with non pk unique field
    Optional<User> findByEmail(String userEmail);
}
