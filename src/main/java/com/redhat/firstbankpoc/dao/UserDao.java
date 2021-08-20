package com.redhat.firstbankpoc.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.firstbankpoc.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
