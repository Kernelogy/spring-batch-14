package com.edex.ecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edex.ecommerce.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public List<User> findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
    public List<User> findByUsernameOrPassword(String username, String password);

    @Query(value = "select * from users where id = ?1", nativeQuery = true)
    public User findByUserId(int id);

    // @Query(value = "select * from users where username = ?1 and password = ?2", nativeQuery = true)
    @Query(value = "select * from users where username = :username and password = :password", nativeQuery = true)
    public User findByUsernameAndPasswordQuery(String username, String password);
}

// firstName  => findByFirstName
// firstname  => findByFirstname
// noOfStudents => findByNoOfStudents
// noofstudents => findByNoofstudents