package com.user.consume.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.consume.model.User;
import com.user.consume.repository.UserRepository;

@RestController
@RequestMapping("/Elastic")
public class SearchController {
	
	@Autowired
	UserRepository repository;
	
	
	@GetMapping(value = "/name/{value}")
    public List<User> searchName(@PathVariable final String value) {
        return repository.findByName(value);
    }
	
	@GetMapping(value = "/all")
    public List<User> searchAll() {
        List<User> usersList = new ArrayList<>();
        Iterable<User> users = repository.findAll();
        users.forEach(usersList::add);
        return usersList;
    }

}
