package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;

public interface StudentRepo extends JpaRepository <Student,Integer> {
    List<Student> findByNameContaining(String name); // Custom query method
  
    
    void deleteById(Integer id); // Override the deleteById method

    

}
