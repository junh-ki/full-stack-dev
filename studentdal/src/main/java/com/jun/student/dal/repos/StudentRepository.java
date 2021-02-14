package com.jun.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.jun.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
