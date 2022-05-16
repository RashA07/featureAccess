package com.example.rasheed.featureAccess.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class ResourceNotUpdatedException extends RuntimeException {
    /*
     * Custom exception to return specific response status
     */

    public ResourceNotUpdatedException() {}

}
