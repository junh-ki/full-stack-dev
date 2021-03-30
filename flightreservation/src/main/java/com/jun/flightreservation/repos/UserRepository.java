package com.jun.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
