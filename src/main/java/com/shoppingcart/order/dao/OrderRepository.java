package com.shoppingcart.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.order.model.OrderMaster;
import com.shoppingcart.order.model.OrderItem;

/*
 * This is repository for item.
 */
@Transactional
public interface OrderRepository extends CrudRepository<OrderMaster,Long> {
	   
	   /**
	    * This method will find Active Order in the database by id
	    * 
	    */
	   @Query("SELECT orderMaster FROM OrderMaster orderMaster where orderMaster.status='active' and orderMaster.orderId=:orderId")
	   public OrderMaster findOrderById(@Param("orderId") Long orderId);

	 	/**
	    * This method will find all Active orders based on orderName
	    * 
	    */
	   @Query("SELECT orderMaster FROM OrderMaster orderMaster where orderMaster.status='active' and  orderMaster.orderName=:orderName")
	   public List<OrderMaster> findOrderByCatagory(@Param("orderName") String orderName);

  
	
	/**
	    * This method will find active Orders
	    * 
	    */
	@Query("SELECT orderMaster FROM OrderMaster orderMaster ,OrderItem orderItem where orderMaster.status='active' and orderMaster.orderId=orderItem.orderId")
	public List<OrderMaster> findAllOrders();
	
	/**
	    * This method will find Order Items
	    * 
	    */
	@Query("SELECT orderItem FROM OrderMaster orderMaster, OrderItem orderItem where orderMaster.status='active' and orderMaster.orderId=orderItem.orderId")
	public List<OrderItem> findAllOrderItems();


}
