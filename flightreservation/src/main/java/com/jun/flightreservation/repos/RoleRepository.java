package com.jun.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
