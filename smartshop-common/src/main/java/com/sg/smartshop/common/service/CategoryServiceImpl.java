/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) Apr 21, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.smartshop.admin.common.util.MappingToPojo;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.dao.CategoryDao;
import com.sg.smartshop.common.helper.PojoCategory;
import com.sg.smartshop.common.helper.PojoProduct;

/**
 * Implementation class for the class CategoryService
 *
 * @version $Id:$
 * @author rbujala (c) Apr 21, 2015, Sogeti B.V.
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService
{

   @Autowired
   private CategoryDao categoryDao;

   /**
    * get list of all the categories
    */
   public List<PojoCategory> getAllCategories()
   {

      return MappingToPojo.getCategoryList(categoryDao.getAllCategories());
   }

   /**
    * Add new Category
    */
   public void addCategory(Category category)
   {
      categoryDao.addCategory(category);
   }

   /**
    * Delete existed category
    */
   public void deleteCategoryById(int id)
   {
      categoryDao.deleteCategory(id);
   }

   /**
    * udpate the existing category
    */
   public void updateCategory(Category category)
   {
      categoryDao.updateCategory(category);

   }

   /**
    * get the list of products based on the category ID
    */
   public List<PojoProduct> getProductsByCategoryId(int id)
   {
      return MappingToPojo.getProductList(categoryDao.getProductsByCategoryId(id));

   }
}
