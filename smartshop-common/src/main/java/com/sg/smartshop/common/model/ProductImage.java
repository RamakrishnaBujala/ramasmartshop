package com.sg.smartshop.common.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PRODUCT_IMAGES database table.
 * 
 */
@Entity
@Table(name="PRODUCT_IMAGES", schema = "SMARTSHOP")
@NamedQuery(name="ProductImage.findAll", query="SELECT p FROM ProductImage p")
public class ProductImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_IMAGES_PRODUCTIMAGESID_GENERATOR", allocationSize=1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_IMAGES_PRODUCTIMAGESID_GENERATOR")
	@Column(name="PRODUCT_IMAGES_ID")
	private int productImagesId;

	@Lob
	@Column(name="PRODUCT_IMAGE")
	private byte[] productImage;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID")
	private Product product;

	public ProductImage() {
	}

	public int getProductImagesId() {
		return this.productImagesId;
	}

	public void setProductImagesId(int productImagesId) {
		this.productImagesId = productImagesId;
	}

	public byte[] getProductImage() {
		return this.productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}