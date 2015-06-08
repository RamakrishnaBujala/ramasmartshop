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

import com.sg.smartshop.common.helper.PojoCategory;
import com.sg.smartshop.common.helper.PojoProduct;
import com.sg.smartshop.common.model.Category;

/**
 * Service class, highlight category operations
 *
 * @version $Id:$
 * @author rbujala (c) Apr 21, 2015, Sogeti B.V.
 */
public interface CategoryService
{
   public List<PojoCategory> getAllCategories();

   public void addCategory(Category category);

   public void deleteCategoryById(int id);   

   public void updateCategory(Category category);

   public List<PojoProduct> getProductsByCategoryId(int id);
}
