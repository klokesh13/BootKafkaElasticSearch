package com.user.consume.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.user.consume.model.User;


public interface UserRepository extends ElasticsearchRepository<User, Long> {
	
	List<User> findByName(String value);

}
