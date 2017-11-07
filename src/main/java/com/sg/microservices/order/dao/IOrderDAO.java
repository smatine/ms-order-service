package com.sg.microservices.order.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sg.microservices.order.entity.Order;


@Component
public interface IOrderDAO {

	public List<Order> getAllOrders();

	public Order getOrderbasedonId(long orderId);

	public Order savenewOrder(Order orderObj);

	public List<Order> getPreviousOrders(String usernameVal);

}
