package com.edex.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edex.ecommerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
