package com.example.rasheed.featureAccess.repository;

import com.example.rasheed.featureAccess.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureRepository extends JpaRepository<Feature, Long> {

    // custom find method with non pk unique field
    Optional<Feature> findByName(String featureName);
}
