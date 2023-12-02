package com.gab.cloudvendorproperties.service;

import com.gab.cloudvendorproperties.model.CloudVendor;
import com.gab.cloudvendorproperties.repository.CloudVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    @Override
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @Override
    public CloudVendor getCloudVendorById(int id) {
        Optional<CloudVendor> vendorOptional = cloudVendorRepository.findById(Math.toIntExact(id));
        return vendorOptional.orElse(null);
    }

    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public CloudVendor updateCloudVendor(int id, CloudVendor cloudVendor) {
        Optional<CloudVendor> existingVendorOptional = cloudVendorRepository.findById(id);
        if (existingVendorOptional.isPresent()) {
            CloudVendor existingVendor = existingVendorOptional.get();
            existingVendor.setId(id);
            existingVendor.setName(cloudVendor.getName());
            existingVendor.setAddress(cloudVendor.getAddress());
            existingVendor.setPhoneNumber(cloudVendor.getPhoneNumber());
            return cloudVendorRepository.save(existingVendor);
        }
        return null;
    }

    @Override
    public boolean deleteCloudVendor(int id) {
        Optional<CloudVendor> vendorOptional = cloudVendorRepository.findById(id);
        if (vendorOptional.isPresent()) {
            cloudVendorRepository.deleteById(Math.toIntExact(id));
            return true;
        }
        return false;
    }
}
