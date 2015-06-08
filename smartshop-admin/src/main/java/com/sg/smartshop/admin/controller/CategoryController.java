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
package com.sg.smartshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.PojoCategory;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.service.CategoryService;
import com.sg.smartshop.common.service.ProductService;

/**
 * Category controller, responsible for all category operations from the UI and this will route to actula servie layer.
 *
 * @version $Id:$
 * @author rbujala (c) Apr 21, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/category")
public class CategoryController
{

   @Autowired
   private CategoryService categoryService;

   @Autowired
   private ProductService productService;

   @RequestMapping("categorieslist.json")
   public @ResponseBody List<PojoCategory> getCategoryList()
   {
      //ObjectMapper mapper = new ObjectMapper();

      return categoryService.getAllCategories();
   }

   @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
   public @ResponseBody void addCategory(@RequestBody Category category)
   {
      categoryService.addCategory(category);
   }

   @RequestMapping(value = "/updateCategory", method = RequestMethod.PUT)
   public @ResponseBody void updateCategory(@RequestBody Category category)
   {
      categoryService.updateCategory(category);
   }

   @RequestMapping(value = "/removeCategory/{id}", method = RequestMethod.DELETE)
   public @ResponseBody void removeCategory(@PathVariable("id") int id)
   {
      categoryService.deleteCategoryById(id);
   }
   

   @RequestMapping("/layout")
   public String getCategoryPartialPage(ModelMap modelMap)
   {
      return "category/layout";
   }
}
