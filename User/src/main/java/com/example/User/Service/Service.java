package com.example.User.Service;

import com.example.User.Exception.MemberNotFoundException;
import com.example.User.Model.User;
import com.example.User.Repository.Repo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@org.springframework.stereotype.Service
public class Service  {

    @Autowired
    Repo repo;

    public List<User> getallusers() {
        List<User> data=new ArrayList<>();

        return Optional.ofNullable(repo.findAll()).orElse(Collections.emptyList());

    }


    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(()->new MemberNotFoundException("Member not found of the given id or user list is empty"));
    }


    public void saveUser(User user) {
      repo.save(user);
    }
}
