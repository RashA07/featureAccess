package com.example.rasheed.featureAccess.controller;

import com.example.rasheed.featureAccess.dto.AccessStatus;
import com.example.rasheed.featureAccess.dto.CreateAccess;
import com.example.rasheed.featureAccess.entity.Feature;
import com.example.rasheed.featureAccess.entity.FeatureAccess;
import com.example.rasheed.featureAccess.entity.FeatureAccessId;
import com.example.rasheed.featureAccess.entity.User;
import com.example.rasheed.featureAccess.exception.ResourceNotFoundException;
import com.example.rasheed.featureAccess.exception.ResourceNotUpdatedException;
import com.example.rasheed.featureAccess.repository.FeatureAccessRepository;
import com.example.rasheed.featureAccess.repository.FeatureRepository;
import com.example.rasheed.featureAccess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/feature")
public class FeatureAccessController {
    /*
     * Handle API endpoints
     * This section includes the logic as well,
     * but alternatively (and ideally), the logic would be defined in a custom service class within a service package
     */

    // variables and auto wire the collaborative beans
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeatureAccessRepository featureAccessRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public void createAccess(@RequestBody CreateAccess request) {
        try {
            // variables
            Feature currentFeat;
            User currentUser;
            FeatureAccess currentFeatAccess;

            // get request object data
            String fName = request.getFeatureName();
            String uEmail = request.getEmail();
            Boolean enable = request.getEnable();

            // check if user and feature exists
            Optional<Feature> thisFeat = featureRepository.findByName(fName);
            Optional<User> thisUser = userRepository.findByEmail(uEmail);
            if (thisFeat.isPresent()) {
                // get feature if exists
                currentFeat = thisFeat.get();
            } else {
                // create feature if absent
                currentFeat = new Feature(fName);
                featureRepository.save(currentFeat);
            }
            if (thisUser.isPresent()) {
                // get user if exists
                currentUser = thisUser.get();
            } else {
                // create user if absent
                currentUser = new User(uEmail);
                userRepository.save(currentUser);
            }

            // create composite id and check if feature access object exists
            FeatureAccessId thisAccessId = new FeatureAccessId(
                    currentFeat.getId(), currentUser.getId());
            Optional<FeatureAccess> thisFeatAccess = featureAccessRepository.findById(thisAccessId);
            if (thisFeatAccess.isPresent()) {
                // update feature access object if present
                currentFeatAccess = thisFeatAccess.get();
                currentFeatAccess.setEnable(enable);
            } else {
                // create feature access object if absent
                currentFeatAccess = new FeatureAccess(currentFeat, currentUser, enable);
            }
            // save the feature access object
            featureAccessRepository.save(currentFeatAccess);

        } catch (Exception e) {
            // return Http Status Not Modiﬁed (304)
            throw new ResourceNotUpdatedException();
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public AccessStatus getAccess(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "featureName") String featureName
    ) {

        // check if user and feature exists
        Optional<Feature> thisFeat = featureRepository.findByName(featureName);
        Optional<User> thisUser = userRepository.findByEmail(email);
        if (thisFeat.isEmpty()) {
            // return Http Status Not Found (404)
            throw new ResourceNotFoundException();
        }
        if (thisUser.isEmpty()) {
            // return Http Status Not Found (404)
            throw new ResourceNotFoundException();
        }

        // create composite id and check if feature access object exists
        FeatureAccessId thisAccessId = new FeatureAccessId(
                thisFeat.get().getId(), thisUser.get().getId());
        Optional<FeatureAccess> thisFeatAccess = featureAccessRepository.findById(thisAccessId);
        if (thisFeatAccess.isEmpty()) {
            // return Http Status Not Found (404)
            throw new ResourceNotFoundException();
        }

        // return access status of feature access object if present
        return new AccessStatus(thisFeatAccess.get().getEnable());

    }

}
