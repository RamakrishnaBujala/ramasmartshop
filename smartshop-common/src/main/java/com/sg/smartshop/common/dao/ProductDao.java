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

import java.util.List;

import com.sg.smartshop.common.model.Product;

/**
 * This will highlight the product operations
 *
 * @version $Id:$
 * @author rbujala (c) Apr 29, 2015, Sogeti B.V.
 */
public interface ProductDao
{
   public List<Product> getAllProducts();

   public void addProduct(Product product);

   public void updateProduct(Product product);

   public void deleteProduct(int id);

   public void deleteAll(); 

   public Product findById(int id);
   
}
