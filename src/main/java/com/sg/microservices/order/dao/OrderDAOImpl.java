package com.sg.microservices.order.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import com.sg.microservices.order.entity.Order;



@Component
public class OrderDAOImpl  implements IOrderDAO{

	@PersistenceContext
	 private EntityManager entityManager;
	
	
	
	@Override
	public List<Order> getAllOrders() {
		    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<Order> criteriaQuery =criteriaBuilder.createQuery(Order.class);
	        Root<Order> orderobj = criteriaQuery.from(Order.class);
	        TypedQuery<Order> typedQuery = entityManager.createQuery(criteriaQuery.select(orderobj));
		    return typedQuery.getResultList();
	}

	@Override
	public Order getOrderbasedonId(long orderId) {

		Order result = null;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
		Root<Order> orderobj = criteriaQuery.from(Order.class);
		TypedQuery<Order> typedQuery = entityManager.createQuery(criteriaQuery
				.select(orderobj)
				.where(criteriaBuilder.and(criteriaBuilder.equal(
						orderobj.get("orderId"), orderId))).distinct(true));
		if (!typedQuery.getResultList().isEmpty() && typedQuery.getResultList() != null) {
			result = typedQuery.getResultList().get(0);
		}

		return result;

	}

	@Override
	public Order  savenewOrder(Order orderObj) {

		entityManager.persist(orderObj);
		entityManager.flush();
		entityManager.refresh(orderObj);
		
		
		return orderObj;
	}

	@Override
	public List<Order> getPreviousOrders(String usernameVal) {
		List<Order> result = null;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
		Root<Order> orderobj = criteriaQuery.from(Order.class);
		TypedQuery<Order> typedQuery = entityManager.createQuery(criteriaQuery
				.select(orderobj)
				.where(criteriaBuilder.and(criteriaBuilder.equal(
						orderobj.get("username"), usernameVal))).distinct(true));
		if (!typedQuery.getResultList().isEmpty() && typedQuery.getResultList() != null) {
			result = typedQuery.getResultList();
		}

		return result;
	}
	
}
