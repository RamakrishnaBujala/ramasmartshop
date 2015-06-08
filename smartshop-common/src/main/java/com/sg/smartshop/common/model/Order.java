package com.sg.smartshop.common.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ORDER" database table.
 * 
 */
@Entity
@Table(name="\"ORDER\"", schema = "SMARTSHOP")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_ORDERID_GENERATOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_ORDERID_GENERATOR")
	@Column(name="ORDER_ID")
	private int orderId;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_BOOKING_DATE")
	private Date orderBookingDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ORDER_CANCEL_DATE")
	private Date orderCancelDate;

	@Column(name="ORDER_STATUS")
	private char orderStatus;

	@Column(name="ORDER_TXN_ID")
	private String orderTxnId;

	@Column(name="SHIPPING_ADDRESS")
	private String shippingAddress;

	@Column(name="SHIPPING_CITY")
	private String shippingCity;

	@Column(name="SHIPPING_PIN")
	private String shippingPin;

	@Column(name="USER_ID")
	private int userId;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderBookingDate() {
		return this.orderBookingDate;
	}

	public void setOrderBookingDate(Date orderBookingDate) {
		this.orderBookingDate = orderBookingDate;
	}

	public Date getOrderCancelDate() {
		return this.orderCancelDate;
	}

	public void setOrderCancelDate(Date orderCancelDate) {
		this.orderCancelDate = orderCancelDate;
	}

	public char getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(char orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderTxnId() {
		return this.orderTxnId;
	}

	public void setOrderTxnId(String orderTxnId) {
		this.orderTxnId = orderTxnId;
	}

	public String getShippingAddress() {
		return this.shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingCity() {
		return this.shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingPin() {
		return this.shippingPin;
	}

	public void setShippingPin(String shippingPin) {
		this.shippingPin = shippingPin;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

}