package com.example.User.Controller;

import com.example.User.Exception.LongValueException;
import com.example.User.Exception.MemberNotFoundException;
import com.example.User.Model.User;
import com.example.User.Service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Controller {

    private Service service;


    public Controller(Service service) {
        this.service = service;
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
    service.saveUser(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getallUser(){
        List<User> data=service.getallusers();
        if(data.size()>0 ) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            throw new MemberNotFoundException("Member List is Empty");
        }
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Object id){
        if(id instanceof Long) {
            return new ResponseEntity<>(service.getUserById((Long) id), HttpStatus.OK);
        }else{
            throw new LongValueException("Input Argument is not valid");
        }
    }

}
