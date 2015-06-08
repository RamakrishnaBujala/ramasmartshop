package com.sg.smartshop.common.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the CATEGORY database table.
 */
@Entity
@Table(name = "CATEGORY", schema = "SMARTSHOP")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable
{
   private static final long serialVersionUID = 1L;

   @Id
   @SequenceGenerator(name = "CATEGORY_CATEGORYID_GENERATOR", allocationSize = 1)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_CATEGORYID_GENERATOR")
   @Column(name = "CATEGORY_ID")
   private int categoryId;

   @Column(name = "CATEGORY_DESCRIPTION")
   private String categoryDescription;

   @Column(name = "CATEGORY_NAME")
   private String categoryName;

   //bi-directional many-to-one association to Product
   @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   private List<Product> products;

   /**
    * Constructor: create a new Category.
    */
   public Category()
   {
   }

   /**
    * 
    * Constructor: create a new Category.
    * @param id
    * @param catName
    * @param catDesc
    */
   public Category(int id, String catName, String catDesc)
   {
      this.categoryId = id;
      this.categoryName = catName;
      this.categoryDescription = catDesc;
   }

   public int getCategoryId()
   {
      return this.categoryId;
   }

   public void setCategoryId(int categoryId)
   {
      this.categoryId = categoryId;
   }

   public String getCategoryDescription()
   {
      return this.categoryDescription;
   }

   public void setCategoryDescription(String categoryDescription)
   {
      this.categoryDescription = categoryDescription;
   }

   public String getCategoryName()
   {
      return this.categoryName;
   }

   public void setCategoryName(String categoryName)
   {
      this.categoryName = categoryName;
   }

   public List<Product> getProducts()
   {
      return this.products;
   }

   public void setProducts(List<Product> products)
   {
      this.products = products;
   }

   public Product addProduct(Product product)
   {
      getProducts().add(product);
      product.setCategory(this);

      return product;
   }

   public Product removeProduct(Product product)
   {
      getProducts().remove(product);
      product.setCategory(null);

      return product;
   }

}