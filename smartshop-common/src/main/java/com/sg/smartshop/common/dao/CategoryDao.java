/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 4, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.dao;

import java.util.List;

import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Product;

/**
 * This class holds the basic operations of the Category, action will be performed by Admin
 *
 * @version $Id:$
 * @author rbujala (c) May 4, 2015, Sogeti B.V.
 */
public interface CategoryDao
{
   public Category findCategoryById(int id);

   public List<Category> getAllCategories();

   public void addCategory(Category category);

   public void updateCategory(Category category);

   public void deleteCategory(int id);

   public void deleteAllCategories();
   
   public List<Product> getProductsByCategoryId(int id);
}
