package com.cg.pizzaorder.beans;

import java.time.LocalDate;

public class PizzaOrder {

	private int orderId;
	private int custId;
	private double totalPrice;
	private LocalDate orderDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "PizzaOrder [orderId=" + orderId + ", custId=" + custId
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ "]";
	}
	
}
