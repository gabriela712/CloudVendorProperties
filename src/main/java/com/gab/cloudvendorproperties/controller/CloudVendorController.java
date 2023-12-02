package com.gab.cloudvendorproperties.controller;

import com.gab.cloudvendorproperties.model.CloudVendor;
import com.gab.cloudvendorproperties.service.CloudVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cloudvendor")
public class CloudVendorController{

    @Autowired
    CloudVendorService cloudVendorService;

    @GetMapping("/{id}")
    public ResponseEntity<CloudVendor> getCloudVendorById(@PathVariable int id){
        CloudVendor vendor = cloudVendorService.getCloudVendorById(id);
        if (vendor != null) {
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CloudVendor> createCloudVendor(@RequestBody CloudVendor cloudVendor) {
        CloudVendor createdVendor = cloudVendorService.createCloudVendor(cloudVendor);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CloudVendor> updateCloudVendor(@PathVariable int id, @RequestBody CloudVendor cloudVendor){
        CloudVendor updatedVendor = cloudVendorService.updateCloudVendor(id, cloudVendor);
        if (updatedVendor != null) {
            return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCloudVendor(@PathVariable int id){
        boolean deleted = cloudVendorService.deleteCloudVendor(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

