package com.jun.vendor.entities.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
