package com.user.consume.loader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.user.consume.model.User;
import com.user.consume.repository.UserRepository;

@Component
public class UserLoader {
	
	// Elastic Load
	@Autowired
	ElasticsearchOperations operations;
			
	@Autowired
	UserRepository repository;
	
	@PostConstruct
	@Transactional
	public void loadAll() {
		
		operations.putMapping(User.class);
        System.out.println("Initial Loading Data");
        Long userId = new Long(199);
        Long age = new Long(22);
        User user = new User("199", userId, "test", age, "world");
        
        repository.save(user);
        System.out.printf("Initial Loading Completed");
	}

}
