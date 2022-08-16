package com.redhat.firstbankpoc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.firstbankpoc.entity.User;
import com.redhat.firstbankpoc.usecase.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    
    
//    private final Tracer tracer = Tracing.init("dao-jpa-backend");
    
    
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers() {

    	
// 	   Span span =  Tracing.startServerSpan(tracer, (HttpHeaders) headers, "format");
//       try (Scope scope = tracer.scopeManager().activate(span)) {
           String helloStr = String.format("Hello, %s!", "getAllUsers");
//           span.log(ImmutableMap.of("event", "string-format", "value", helloStr));
           return  this.userService.getAllUsers();
//       } finally {
//           span.finish();
//       }
       
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }


    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<User> getUser(@PathVariable int id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllUsers() {
        this.userService.deleteAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUserById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given user context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a user-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}
