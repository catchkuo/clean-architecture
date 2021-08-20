package com.redhat.firstbankpoc.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redhat.firstbankpoc.entity.Account;

@Repository
public interface AccoountDao extends JpaRepository<Account, Integer> {
}
