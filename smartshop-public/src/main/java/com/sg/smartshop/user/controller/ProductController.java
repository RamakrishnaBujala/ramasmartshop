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
package com.sg.smartshop.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.PojoCategory;
import com.sg.smartshop.common.helper.PojoProduct;
import com.sg.smartshop.common.model.Product;
import com.sg.smartshop.common.service.CategoryService;
import com.sg.smartshop.common.service.ProductService;

/**
 * ProdutController, will handle all prodcut realted actions from the UI
 *
 * @version $Id:$
 * @author rbujala (c) Apr 21, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/products")
public class ProductController
{
   public static Logger log = LoggerFactory.getLogger(ProductController.class);

   @Autowired
   private ProductService productService;

   @Autowired
   private CategoryService categoryService;

   @RequestMapping("/productlist.json")
   public @ResponseBody List<PojoProduct> getProductList()
   {
      log.info("::Getting product list ::");
      return productService.getAllProducts();
   }

   @RequestMapping("/categorylist.json")
   public @ResponseBody List<PojoCategory> getCatgoriesList()
   {
      log.info("::Getting category list ::");
      return categoryService.getAllCategories();
   }

   @RequestMapping(value = "/getProductsByCategoryId.json/{categoryId}")
   public @ResponseBody List<PojoProduct> getProductsByCategoryId(@PathVariable("categoryId") int categoryId)
   {
      return categoryService.getProductsByCategoryId(categoryId);
   }

   @RequestMapping("/layout")
   public String getUserPartialPage()
   {
      return "products/layout";
   }
}
