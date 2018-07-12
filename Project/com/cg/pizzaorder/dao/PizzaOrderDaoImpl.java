package com.cg.pizzaorder.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pizzaorder.beans.Customer;
import com.cg.pizzaorder.beans.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderDaoImpl implements IPizzaOrderDAO{

	//map for orderid and pizza order
	Map<Integer, PizzaOrder> pizzaEntry;
	//map for customerid and customer object
	Map<Integer,Customer> customerEntry;
	
	public PizzaOrderDaoImpl(){
		pizzaEntry= new HashMap<Integer, PizzaOrder>();
		customerEntry= new HashMap<Integer,Customer>();
	}
	
	private int generateOrderId(){
		int id= (int) Math.round(Math.random()*1000);
		return id;
	}
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		// TODO Auto-generated method stub
		Integer custId= generateCustomerId();
		int id=generateOrderId();
		customer.setCustomerId(custId);
		customerEntry.put(custId, customer);
		pizza.setOrderId(id);
		pizza.setCustId(custId);
		pizzaEntry.put(id, pizza);
		return id;
	}
	private Integer generateCustomerId() {
		// TODO Auto-generated method stub
		int id= (int) Math.round(Math.random()*10000);
		return id;
	}

	@Override
	public Customer getCustomerDetails(int custid) {

		Customer cust= customerEntry.get(custid);
		return cust;
	}

	@Override
	public PizzaOrder getORderDetails(int orderid) throws PizzaException {
		PizzaOrder order = pizzaEntry.get(orderid);
		if(order==null)
			throw new PizzaException("Order ID does Not exist" );
		return order;
	}

}
