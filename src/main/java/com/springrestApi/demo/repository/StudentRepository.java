package com.springrestApi.demo.repository;

import com.springrestApi.demo.model.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {



   List<Student> findByAge(Integer age);
}
