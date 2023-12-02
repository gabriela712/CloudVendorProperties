package com.gab.cloudvendorproperties.repository;

import com.gab.cloudvendorproperties.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,Integer> {
}
