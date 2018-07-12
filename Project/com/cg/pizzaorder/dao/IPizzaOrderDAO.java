package com.cg.pizzaorder.dao;

import com.cg.pizzaorder.beans.Customer;
import com.cg.pizzaorder.beans.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public interface IPizzaOrderDAO {
	public int placeOrder(Customer customer,PizzaOrder pizza) throws PizzaException;

	public Customer getCustomerDetails(int custid);

	public PizzaOrder getORderDetails(int orderid) throws PizzaException;
}
