package com.example.rasheed.featureAccess.dto;

import lombok.Data;

@Data
public class AccessStatus {
    /*
    * Custom output template
    */

    // variables
    private Boolean canAccess;

    // constructors
    public AccessStatus() {}

    public AccessStatus(Boolean canAccess) {
        this.canAccess = canAccess;
    }

    // getters and setters
    public Boolean getCanAccess() {
        return canAccess;
    }

    public void setCanAccess(Boolean canAccess) {
        this.canAccess = canAccess;
    }

}
