package com.example.rasheed.featureAccess.dto;

import lombok.Data;

@Data
public class CreateAccess {
    /*
     * Custom input template
     */

    // variables
    private String featureName;
    private String email;
    private Boolean enable;

    // constructors
    public CreateAccess(String featureName, String email, Boolean enable) {
        this.featureName = featureName;
        this.email = email;
        this.enable = enable;
    }

}
