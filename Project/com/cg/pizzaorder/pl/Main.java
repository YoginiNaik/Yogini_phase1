package com.cg.pizzaorder.pl;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.pizzaorder.beans.Customer;
import com.cg.pizzaorder.beans.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		IPizzaOrderService service= new PizzaOrderServiceImpl();
	Customer customer= new Customer();
	PizzaOrder order=new PizzaOrder();
     Scanner sc= new Scanner(System.in);
	System.out.println("---------Place Order Here-----------");
	System.out.println("Enter Name :");
	customer.setCustName(sc.next());
	System.out.println("Enter Address ");
	customer.setAddress(sc.next());
	System.out.println("Enter Mobile no ");
	customer.setPhone(sc.next());
	System.out.println("Select type of Topping : ");
	System.out.println("1. Capsicum ");
	System.out.println("2. Mashrom ");
	System.out.println("3. Jalapano ");
	System.out.println("4. Panner ");
	int topping =sc.nextInt();
	if(service.validateDetails(customer)==null){
		System.out.println("Invalid mobile no ");
	}
	else{
	order.setOrderDate(LocalDate.now());

	double price = service.getOrderBill(topping);
	order.setTotalPrice(price);

	try {
		
		int id= service.placeOrder(customer, order);
		System.out.println("Your Total Bill : "+price);
		System.out.println("Your order is placed ..."+id);
		
		System.out.println("Enter id ");
		id= sc.nextInt();
		PizzaOrder order1= service.getOrderDetails(id);
		System.out.println("Your order details : ");
		System.out.println(order1);
	} catch (PizzaException e) {
		System.out.println(e.getMessage());
	}
	}
	}
}
