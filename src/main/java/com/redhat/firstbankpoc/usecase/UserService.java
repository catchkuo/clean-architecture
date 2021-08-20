package com.redhat.firstbankpoc.usecase;

import com.redhat.firstbankpoc.dao.UserDao;
import com.redhat.firstbankpoc.entity.User;
import com.redhat.firstbankpoc.gateways.BlackName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return this.userDao.findAll();
    }

    public User addUser(User user) {
    	
    	if(BlackName.check(user)) {
    		return this.userDao.save(user);
    	}else {
    		return user;
    	}
        
    }

    //other methods go here


    public Optional<User> getUserById(int id) {
        return this.userDao.findById(id);
    }

    public User updateUser(User user) {
        return this.userDao.save(user);
    }

    public void deleteUserById(int id) {
        this.userDao.deleteById(id);
    }

    public void deleteAllUsers() {
        this.userDao.deleteAll();
    }


}
