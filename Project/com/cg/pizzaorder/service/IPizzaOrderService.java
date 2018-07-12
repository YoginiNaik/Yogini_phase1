package com.cg.pizzaorder.service;

import com.cg.pizzaorder.beans.Customer;
import com.cg.pizzaorder.beans.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public interface IPizzaOrderService {
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException;
	public double getOrderBill(int topping);
	public Customer getCustomerDetails(int custid);
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException;
	public Customer validateDetails(Customer cust);
}
