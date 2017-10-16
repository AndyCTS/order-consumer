package com.shoppingcart.order;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.shoppingcart.order.model.OrderMaster;

@SpringBootApplication
//@EnableDiscoveryClient
public class OrderConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderConsumerApplication.class, args);
	}
	
	@RabbitListener(queues="spring-boot1")
	public void processMessage(OrderMaster orderMaster) {
		System.out.println(" **** \n\n\n\n **** ORDER CONSUMED: " + orderMaster);
	}
	
	
}
