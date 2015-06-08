package com.sg.smartshop.common.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ORDER_DETAILS database table.
 * 
 */
@Entity
@Table(name="ORDER_DETAILS", schema = "SMARTSHOP")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_DETAILS_ORDERDETAILSID_GENERATOR", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_DETAILS_ORDERDETAILSID_GENERATOR")
	@Column(name="ORDER_DETAILS_ID")
	private int orderDetailsId;

	@Column(name="ORDER_DETAILS_PRICE")
	private double orderDetailsPrice;

	@Column(name="ORDER_DETAILS_QTY")
	private int orderDetailsQty;

	@Column(name="PRODUCT_ID")
	private int productId;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private Order order;

	public OrderDetail() {
	}

	public int getOrderDetailsId() {
		return this.orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public double getOrderDetailsPrice() {
		return this.orderDetailsPrice;
	}

	public void setOrderDetailsPrice(double orderDetailsPrice) {
		this.orderDetailsPrice = orderDetailsPrice;
	}

	public int getOrderDetailsQty() {
		return this.orderDetailsQty;
	}

	public void setOrderDetailsQty(int orderDetailsQty) {
		this.orderDetailsQty = orderDetailsQty;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}