package com.sg.microservices.order.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;



@Entity
@Table(name="ORDER_DETAILS")
@Component
public class Order {
	
	public Order(){
		
	}

	public Order(long orderid, long productid, String username,
			String paymentMode, String billingAddress, String deliveryAddr,
			int orderQuantity, long totalamt, Date orderDate) {
		super();
		this.orderId = orderid;
		this.productId = productid;
		this.username = username;
		this.paymentMode = paymentMode;
		this.billingAddress = billingAddress;
		this.deliveryAddr = deliveryAddr;
		this.orderQuantity = orderQuantity;
		this.totalAmt = totalamt;
		this.orderDate = orderDate;
	}
	 
	
	
	
    	@Id
	    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    	 @SequenceGenerator(name="public.order_sequence",
         sequenceName="public.order_sequence",
         allocationSize=1)
    	@GeneratedValue(strategy = GenerationType.SEQUENCE,
      generator="public.order_sequence")
		@Column(name = "orderid") 
		private long  orderId;
    	
    	@Column(name="productid")
    	private long productId;
    	
    	@Column(name="username")
    	//private long customerId;
    	private String username;
    	
    	
    	@Column(name="paymentMode")
    	private String paymentMode;
    	
	
    	 @Column(name="billingAddr")
    	 private String billingAddress;
    	 
    	 
    	 @Column(name="deliveryAddr")
    	 private String deliveryAddr;
    	 
    	 
    	 @Column(name="orderquantity")
    	 private int orderQuantity;

    	 
    	 @Column(name="totalamt")
    	 private long totalAmt;

    	 
    	 @Column(name="OrderDate",columnDefinition="DATETIME")
    	 @Temporal(TemporalType.DATE)
    	 private Date orderDate = new java.util.Date();


		public long getOrderid() {
			return orderId;
		}


		public void setOrderid(long orderid) {
			this.orderId = orderid;
		}


		public long getProductid() {
			return productId;
		}


		public void setProductid(long productid) {
			this.productId = productid;
		}


	


		public String getPaymentMode() {
			return paymentMode;
		}


		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}


		public String getBillingAddress() {
			return billingAddress;
		}


		public void setBillingAddress(String billingAddress) {
			this.billingAddress = billingAddress;
		}


		public String getDeliveryAddr() {
			return deliveryAddr;
		}


		public void setDeliveryAddr(String deliveryAddr) {
			this.deliveryAddr = deliveryAddr;
		}


		public int getOrderQuantity() {
			return orderQuantity;
		}


		public void setOrderQuantity(int orderQuantity) {
			this.orderQuantity = orderQuantity;
		}


		public long getTotalamt() {
			return totalAmt;
		}


		public void setTotalamt(long totalamt) {
			this.totalAmt = totalamt;
		}


		public Date getOrderDate() {
			return orderDate;
		}


		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}


		@Override
		public String toString() {
			return "OrderPOJO [orderid=" + orderId + ", productid=" + productId
					+ ", username=" + username + ", paymentMode="
					+ paymentMode + ", billingAddress=" + billingAddress
					+ ", deliveryAddr=" + deliveryAddr + ", orderQuantity="
					+ orderQuantity + ", totalamt=" + totalAmt + ", orderDate="
					+ orderDate + "]";
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}


		
    	 
}
