package com.shoppingcart.order.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.support.converter.SerializerMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitListenerConfig {

    private final ConnectionFactory connectionFactory;

    @Autowired
    public RabbitListenerConfig(ConnectionFactory connectionFactory){
        this.connectionFactory = connectionFactory;
    }
    
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
    	SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    	factory.setConnectionFactory(this.connectionFactory);
    	factory.setMessageConverter(new Jackson2JsonMessageConverter(new ObjectMapper()));
//    	factory.setMessageConverter(new SerializerMessageConverter());
    	
    	
    	return factory;
    }
    
    @Bean
    public Queue queue() {
    	return new Queue("spring-boot1", true);
/*    	ToDo: a false argument here was throwing the error although this was taught in the lab. 
    	It needs to be seen - if a false argument will compile the code when the queue is not created and the 
    	code is written for the first Time.
*/    	
    }
    
    

}
