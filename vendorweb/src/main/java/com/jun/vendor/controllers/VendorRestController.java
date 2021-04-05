package com.jun.vendor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.vendor.dto.VendorUpdateRequest;
import com.jun.vendor.entities.Vendor;
import com.jun.vendor.entities.repos.VendorRepository;

@RestController
@CrossOrigin
public class VendorRestController {

    @Autowired
    VendorRepository vendorrepository;
    
    @RequestMapping("/vendors/{id}")
    public Vendor findVendor(@PathVariable Long id) {
        return vendorrepository.findById(id.intValue()).get();
    }
    
    @RequestMapping("/vendors")
    public Vendor updateVendor(@RequestBody VendorUpdateRequest request) {
        Vendor vendor = vendorrepository.findById(request.getId().intValue()).get();
        vendor.setEmail(request.getEmail());
        vendor.setPhone(request.getPhone());
        vendor.setAddress(request.getAddress());
        return vendorrepository.save(vendor);
    }
    
}
