package com.edex.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.ecommerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public List<User> findByUsername(String username);
}

// firstName  => findByFirstName
// firstname  => findByFirstname
// noOfStudents => findByNoOfStudents
// noofstudents => findByNoofstudents