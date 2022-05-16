package com.example.rasheed.featureAccess.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name="users")
public class User {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_email", unique = true)
    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<FeatureAccess> accFeats;

    // constructors
    public User(String email) {
        this.email = email;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<FeatureAccess> getAccFeats() {
        return accFeats;
    }

    public void setAccFeats(Set<FeatureAccess> accFeats) {
        this.accFeats = accFeats;
    }

}
