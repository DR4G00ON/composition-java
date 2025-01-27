package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private static List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order() {
	
	}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:");
		sb.append("Order moment: "+sdf.format(moment)+"\n");
		sb.append("Order statud: "+status+"\n");
		sb.append("Client: "+client+"\n");
		sb.append("Order items:\n");
		for(OrderItem item : items) {
			sb.append(item+"\n");
		}
		sb.append("Total price: $"+total());
		return sb.toString();
	}
	public static double total() {
		double sum = 00.0; 
		for(OrderItem oi : items) {
			sum += oi.subTotal();
		}
		return sum;
	}
}
