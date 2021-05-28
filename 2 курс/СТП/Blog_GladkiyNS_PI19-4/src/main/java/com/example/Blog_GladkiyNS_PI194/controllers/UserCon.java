package com.example.Blog_GladkiyNS_PI194.controllers;

import com.example.Blog_GladkiyNS_PI194.entities.User;
import com.example.Blog_GladkiyNS_PI194.services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserCon {
    private final UserServ userServ;

    @Autowired
    public UserCon(UserServ userServ){
        this.userServ = userServ;
    }

    @PostMapping(value = "/api/users")
    public ResponseEntity<?> create(@RequestBody User user){
        userServ.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/api/users")
    public  ResponseEntity<List<User>> findAll(){
        final List<User> blogList = userServ.findAll();
        if (blogList != null) {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<?> find(@PathVariable(name = "id") Long id){
        final Optional<User> blog = userServ.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/api/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable(name = "id")Long id){
        if (userServ.findById(id).isPresent()) {
            userServ.updateUser(user, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(value = "/api/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long id){
        if (userServ.findById(id).isPresent()){
            userServ.deleteUser(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/api/users")
    public void deleteAll(){
        userServ.deleteAll();
    }
}
