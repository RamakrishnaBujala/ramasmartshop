/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) Jun 3, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sg.smartshop.common.dao.ProductDao;
import com.sg.smartshop.common.model.Product;

/**
 * Test class product operatios.
 *
 * @version $Id:$
 * @author rbujala (c) Jun 3, 2015, Sogeti B.V.
 */
@ContextConfiguration(locations = { "classpath:spring-dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest
{
   private static Product product = null;

   @Autowired
   private ProductDao productDao;

   @BeforeClass
   public static void setUp() throws Exception
   {
      product = new Product();
      product.setProductName("Test Product");
      product.setProdcutDesc("Test Product");
      BigDecimal bDecimal = BigDecimal.valueOf(12);
      product.setProductPrice(bDecimal);
   }

   @Test
   public void testACategoryInsertion() throws SQLException
   {
      //No sql exception means, test is passing here as addCategory return nothing
      Throwable caught = null;
      try
      {
         productDao.addProduct(product);
      }
      catch (Throwable t)
      {
         caught = t;
      }

      assertNull(caught);

   }

   @Test
   public void testBExistedCategory() throws SQLException
   {
      assertNotNull(productDao.getAllProducts());
   }

   @Test
   public void testCDeleteProduct() throws SQLException
   {

      List<Product> productList = productDao.getAllProducts();

      Product testProduct = null;
      for (Product prod : productList)
      {
         if (prod.getProductName().equals("Test Product"))
         {
            testProduct = prod;
            break;
         }
      }

      Product product1 = productDao.findById(testProduct.getProductId());
      assertEquals("Test Product", testProduct.getProductName());

      //remove the test category
      productDao.deleteProduct(testProduct.getProductId());

   }
}
