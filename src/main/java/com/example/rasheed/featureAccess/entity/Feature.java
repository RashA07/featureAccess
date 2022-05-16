package com.example.rasheed.featureAccess.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "features")
public class Feature {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name", unique = true)
    private String name;

    @OneToMany(
            mappedBy = "feature",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<FeatureAccess> accFeats;

    // constructors
    public Feature(String name) {
        this.name = name;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FeatureAccess> getAccFeats() {
        return accFeats;
    }

    public void setAccFeats(Set<FeatureAccess> accFeats) {
        this.accFeats = accFeats;
    }

}
