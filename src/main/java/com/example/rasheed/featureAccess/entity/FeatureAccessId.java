package com.example.rasheed.featureAccess.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class FeatureAccessId implements Serializable {

    // variables
    @Column
    private Long featureId;
    @Column
    private Long userId;

    // constructors
    public FeatureAccessId(Long featureId, Long userId) {
        this.featureId = featureId;
        this.userId = userId;
    }

    // getters and setters
    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // overridden methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureAccessId that = (FeatureAccessId) o;
        return featureId.equals(that.featureId) && userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(featureId, userId);
    }

}
