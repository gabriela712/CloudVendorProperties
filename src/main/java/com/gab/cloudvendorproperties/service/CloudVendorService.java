package com.gab.cloudvendorproperties.service;

import com.gab.cloudvendorproperties.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    List<CloudVendor> getAllCloudVendors();
    CloudVendor getCloudVendorById(int id);
    CloudVendor createCloudVendor(CloudVendor cloudVendor);
    CloudVendor updateCloudVendor(int id, CloudVendor cloudVendor);
    boolean deleteCloudVendor(int id);

}

