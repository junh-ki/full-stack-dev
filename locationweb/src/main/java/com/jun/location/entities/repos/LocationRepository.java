package com.jun.location.entities.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
