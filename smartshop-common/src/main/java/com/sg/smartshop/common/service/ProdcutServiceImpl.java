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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.smartshop.admin.common.util.MappingToPojo;
import com.sg.smartshop.common.model.Product;
import com.sg.smartshop.common.dao.ProductDao;
import com.sg.smartshop.common.helper.PojoProduct;

/**
 * ProdcutServiceImpl, implementation class of ProductService
 *
 * @version $Id:$
 * @author rbujala (c) Apr 21, 2015, Sogeti B.V.
 */
@Service("productService")
public class ProdcutServiceImpl implements ProductService
{
   @Autowired
   ProductDao productDao;

  /**
   * list out all the products
   */
   public List<PojoProduct> getAllProducts()
   {
      return MappingToPojo.getProductList(productDao.getAllProducts());
   }

  
   /**
    * Add the new product
    */
   public void addProduct(Product product)
   {
      productDao.addProduct(product);
   }


   /**
    * Delete the existed product
    */
   public void deleteProduct(int id)
   {
      productDao.deleteProduct(id);
   }

   
   /**
    * deelte the existed prodcut
    */
   public void deleteAll()
   {
      productDao.deleteAll();
   }

  
   /**
    * Edit the existed product
    * TODO
    * @param product
    */
   public void editProduct(PojoProduct product)
   {
      productDao.updateProduct(MappingToPojo.getModelProduct(product));
   }
}
