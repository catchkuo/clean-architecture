package com.redhat.firstbankpoc.controller;

import com.redhat.firstbankpoc.entity.User;
import com.redhat.firstbankpoc.usecase.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/remittance")
public class RemittanceController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "inward", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }


}
