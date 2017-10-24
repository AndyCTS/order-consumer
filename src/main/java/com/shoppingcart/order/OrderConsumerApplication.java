package com.shoppingcart.order;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.client.RestTemplate;

import com.shoppingcart.order.model.OrderMaster;
import com.shoppingcart.order.service.IOrderService;
//import com.netflix.discovery.EurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsumerApplication {
	
	@Autowired
	IOrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(OrderConsumerApplication.class, args);
	}
	
	@RabbitListener(queues="spring-boot1")
	public void processMessage(OrderMaster orderMaster) {
		System.out.println(" **** \n\n\n\n **** ORDER CONSUMED: " + orderMaster);
		
		orderService.addOrder(orderMaster);
		System.out.println(" **** \n\n\n\n **** ORDER Saved: " + orderMaster);


		
//		OrderMaster returnParameter = new RestTemplate().postForObject(AppInEurekaURL, orderMaster, OrderMaster.class);

	}
	
	
}
