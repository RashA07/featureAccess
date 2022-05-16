package com.example.rasheed.featureAccess.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="feature_users")
public class FeatureAccess {

    // variables
    @EmbeddedId
    private FeatureAccessId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("featureId")
    private Feature feature;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Column(name = "feature_enable")
    private Boolean enable;

    // constructors
    public FeatureAccess(Feature feature, User user, Boolean enable) {
        this.feature = feature;
        this.user = user;
        this.id = new FeatureAccessId(feature.getId(), user.getId());
        this.enable = enable;
    }

    // getters and setters
    public FeatureAccessId getId() {
        return id;
    }

    public void setId(FeatureAccessId id) {
        this.id = id;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

}
