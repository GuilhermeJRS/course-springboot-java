package com.julgab.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.julgab.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant monent;
	
	private Integer orderStatus;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client; 
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> orderItems =new HashSet<>();
	
	/*
	 * Cascade é uma anotação obrigatória num relacionamento OneToOne e faz com que o Payment tenha o mesmo id do Order.
	 */
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment; 
	
	public Order() {
	}

	public Order(Integer id, Instant monent, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.monent = monent;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getMonent() {
		return monent;
	}

	public void setMonent(Instant monent) {
		this.monent = monent;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();			
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getOrderItems(){
		return orderItems;
	}
	
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public Double getTotal(){
		Double sum = 0.0;
		 for (OrderItem orderItem : orderItems) {
			 sum += orderItem.getSubTotal();
		 }
		 return sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
