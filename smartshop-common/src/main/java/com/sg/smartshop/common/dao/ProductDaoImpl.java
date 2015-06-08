/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) Apr 29, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Product;

/**
 * Class, will implement the operations of ProductDao.
 *
 * @version $Id:$
 * @author rbujala (c) Apr 29, 2015, Sogeti B.V.
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{
   public static Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);

   @PersistenceContext
   private EntityManager entityManager;

   //storing product values in cache
   private List<Product> productListCache = new ArrayList<Product>();

   /**
    * Method, will get all the prodcut records.
    */
   public List<Product> getAllProducts()
   {
      log.info(":: getting all the prodcuts :: ");
      if (productListCache.size() < 1)
      {
         return updateProductList();
      }
      else
      {
         return productListCache;
      }
   }

   /**
    * Method, will add the new product
    */
   public void addProduct(Product product)
   {
      log.info(":: add product :: ");
      entityManager.persist(product);

      //finally upate the product list into cache.
      updateProductList();
   }

   /**
    * Method, will update the existing product record.
    * 
    * @param product
    */
   public void updateProduct(Product product)
   {
      log.info(":: upate product :: ");

      entityManager.merge(product);

      //finally upate the product list into cache.
      updateProductList();
   }

   /**
    * Mehtod, will delete the product record based on the id
    * 
    * @param id
    */
   public void deleteProduct(int id)
   {
      entityManager.remove(findById(id));

      //finally upate the product list into cache.
      updateProductList();
   }

   /**
    * Method, delete all the product records from the Product table
    */
   public void deleteAll()
   {
      entityManager.detach(Product.class);

      //finally upate the product list into cache.
      updateProductList();
   }

   /**
    * Method, will return the Product details based on the ID.
    * 
    * @param id
    * @return Product record
    */
   public Product findById(int id)
   {
      return (Product) entityManager.find(Product.class, id);
   }

   /**
    * Return the list of Products.
    * 
    * @return Product List.
    */
   private List<Product> updateProductList()
   {
      log.info(":: storing the products in cahce list :: ");
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Product> cQurey = builder.createQuery(Product.class);
      Root<Product> root = cQurey.from(Product.class);
      cQurey.select(root);

      //store the list of products in cache at first invoke from smartshop-public portal.
      productListCache = entityManager.createQuery(cQurey).getResultList();
      log.info(":: storing the products in cahce list done! :: ");
      return productListCache;
   }

}
