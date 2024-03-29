package com.example.spring_boot_security.repository;

import com.example.spring_boot_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.userName=:username")
    User getUsersByName(@Param("username") String username);



}


