package com.example.rasheed.featureAccess.repository;

import com.example.rasheed.featureAccess.entity.FeatureAccess;
import com.example.rasheed.featureAccess.entity.FeatureAccessId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureAccessRepository extends JpaRepository<FeatureAccess, FeatureAccessId> {
}
