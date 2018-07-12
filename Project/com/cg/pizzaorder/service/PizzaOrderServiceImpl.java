package com.cg.pizzaorder.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pizzaorder.beans.Customer;
import com.cg.pizzaorder.beans.PizzaOrder;
import com.cg.pizzaorder.dao.IPizzaOrderDAO;
import com.cg.pizzaorder.dao.PizzaOrderDaoImpl;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderServiceImpl implements IPizzaOrderService{

	IPizzaOrderDAO dao;
	public PizzaOrderServiceImpl(){
		dao= new PizzaOrderDaoImpl();
	}
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		return dao.placeOrder(customer, pizza);
	}

	public double getOrderBill(int topping){
		double price= 350;
		switch(topping){
		case 1 :
			price= price+ 30;
			break;
		case 2: 
			price= price +50;
			break;
		case 3:
			price= price +70;
			break;
		case 4 :price= price+85;
		break;
		default : 
			System.out.println("No topping selected ...");
		}
		return price;
	}
	@Override
	public Customer getCustomerDetails(int custid) {
		return dao.getCustomerDetails(custid);
	}
	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		return dao.getORderDetails(orderid);
	}
	@Override
	public Customer validateDetails(Customer cust) {
		Pattern pat= Pattern.compile("[0-9]{10}");
		Matcher mat= pat.matcher(cust.getPhone());
		if(mat.matches())
			return cust;
		else
			return null;
	}
}
