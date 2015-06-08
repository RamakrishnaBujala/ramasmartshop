package com.sg.smartshop.common.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the PRODUCT database table.
 */
@Entity
@Table(name = "PRODUCT", schema = "SMARTSHOP")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "PRODUCT_PRODUCTID_GENERATOR", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCTID_GENERATOR")
   @Column(name = "PRODUCT_ID")
   private int productId;

   @Column(name = "PRODCUT_DESC")
   private String prodcutDesc;

   @Column(name = "PRODUCT_NAME")
   private String productName;

   @Column(name = "PRODUCT_PRICE")
   private BigDecimal productPrice;

   //bi-directional many-to-one association to Category
   @ManyToOne
   @JoinColumn(name = "CATEGORY_ID")
   private Category category;

   //bi-directional many-to-one association to ProductImage
   @OneToMany(mappedBy = "product")
   private List<ProductImage> productImages;

   /**
    * Constructor: create a new Product.
    */
   public Product()
   {
   }

   /**
    * 
    * Constructor: create a new Product.
    * @param id
    * @param prdName
    * @param prodPrice
    * @param prodDesc
    */
   public Product(int id, String prdName, BigDecimal prodPrice, String prodDesc)
   {
      this.productId = id;
      this.productName = prdName;
      this.productPrice = prodPrice;
      this.prodcutDesc = prodDesc;
   }

   public int getProductId()
   {
      return this.productId;
   }

   public void setProductId(int productId)
   {
      this.productId = productId;
   }

   public String getProdcutDesc()
   {
      return this.prodcutDesc;
   }

   public void setProdcutDesc(String prodcutDesc)
   {
      this.prodcutDesc = prodcutDesc;
   }

   public String getProductName()
   {
      return this.productName;
   }

   public void setProductName(String productName)
   {
      this.productName = productName;
   }

   public BigDecimal getProductPrice()
   {
      return this.productPrice;
   }

   public void setProductPrice(BigDecimal productPrice)
   {
      this.productPrice = productPrice;
   }

   public Category getCategory()
   {
      return this.category;
   }

   public void setCategory(Category category)
   {
      this.category = category;
   }

   public List<ProductImage> getProductImages()
   {
      return this.productImages;
   }

   public void setProductImages(List<ProductImage> productImages)
   {
      this.productImages = productImages;
   }

   public ProductImage addProductImage(ProductImage productImage)
   {
      getProductImages().add(productImage);
      productImage.setProduct(this);

      return productImage;
   }

   public ProductImage removeProductImage(ProductImage productImage)
   {
      getProductImages().remove(productImage);
      productImage.setProduct(null);

      return productImage;
   }

}