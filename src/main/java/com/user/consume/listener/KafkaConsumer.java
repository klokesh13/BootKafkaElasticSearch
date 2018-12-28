package com.user.consume.listener;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.consume.model.User;
import com.user.consume.repository.UserRepository;

import scala.runtime.TraitSetter;

@Service
public class KafkaConsumer {


	// Elastic Load
	@Autowired
	ElasticsearchOperations operations;
		
	@Autowired
	UserRepository repository;
	
    private static final String KAFKA_GROUP_ID="group_message";
    
    private static final String USER_KAFKA_GROUP_ID="group_json";
	
	@KafkaListener( topics = "JsonMsgTopic", group = KAFKA_GROUP_ID)
	public void consumeMessage(String message) {
		
		System.out.println("Consumed message: "+message);
		
	}
	
	@KafkaListener( topics = "JsonMsgTopic", group = USER_KAFKA_GROUP_ID, containerFactory="userKafkaListenerContainerFactory")
	public void consumeUser(User user) {
		
		System.out.println("Consumed User: "+user);
		
		operations.putMapping(User.class);
        System.out.println("Loading Consumed Data");
        repository.save(user);
        System.out.printf("Loading Consumed Data Completed");
		
	}
	
	
	

}
