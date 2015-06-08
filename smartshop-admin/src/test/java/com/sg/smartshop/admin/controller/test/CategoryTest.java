/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 28, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.controller.test;

import static org.junit.Assert.*;

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

import com.sg.smartshop.common.dao.CategoryDao;
import com.sg.smartshop.common.model.Category;

/**
 * Test case for Category/Category operation
 *
 * @version $Id:$
 * @author rbujala (c) May 28, 2015, Sogeti B.V.
 */

@ContextConfiguration(locations = { "classpath:spring-dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryTest
{
   private static Category category = null;

   @Autowired
   private CategoryDao categoryDao;

   @BeforeClass
   public static void setUp() throws Exception
   {
      category = new Category();
      category.setCategoryName("Test Category");
      category.setCategoryDescription("Test Catgory");
   }

   @Test
   public void testACategoryInsertion() throws SQLException
   {
      //No sql exception means, test is passing here as addCategory return nothing
      Throwable caught = null;
      try
      {
         categoryDao.addCategory(category);
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
      assertNotNull(categoryDao.getAllCategories());
   }

   @Test
   public void testCCategoryById() throws SQLException
   {

      List<Category> categoryList = categoryDao.getAllCategories();
      Category testCategory = null;
      for (Category cat : categoryList)
      {
         if (cat.getCategoryName().equals("Test Category"))
         {
            testCategory = cat;
            break;
         }
      }
      Category categoryFromById = categoryDao.findCategoryById(testCategory.getCategoryId());
      assertEquals("Test Category", categoryFromById.getCategoryName());

      //remove the test category
      categoryDao.deleteCategory(categoryFromById.getCategoryId());
   }
}