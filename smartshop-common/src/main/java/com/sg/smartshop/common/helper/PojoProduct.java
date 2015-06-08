/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 21, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.helper;

import java.math.BigDecimal;

/**
 * Helper class to hold the Product model.
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */

public class PojoProduct
{

   private int productId;

   private String prodcutDesc;

   private String productName;

   private BigDecimal productPrice;

   private PojoCategory category;

   /**
    * Get the productDesc.
    *
    * @return Returns the productDesc as a String.
    */
   public String getProductDesc()
   {
      return prodcutDesc;
   }

   /**
    * Set the productDesc to the specified value.
    *
    * @param productDesc The productDesc to set.
    */
   public void setProductDesc(String productDesc)
   {
      this.prodcutDesc = productDesc;
   }

   /**
    * Get the categoryId.
    *
    * @return Returns the categoryId as a int.
    */
   public PojoCategory getCategory()
   {
      return category;
   }

   /**
    * Set the categoryId to the specified value.
    *
    * @param categoryId The categoryId to set.
    */
   public void setCategory(PojoCategory category)
   {
      this.category = category;
   }

   public int getProdcutId()
   {
      return this.productId;
   }

   public void setProdcutId(int productId)
   {
      this.productId = productId;
   }

   public String getProdcutDesc()
   {
      return this.prodcutDesc;
   }

   public void setProdcutDesc(String prodcutDesc)
   {
      this.prodcutDesc = prodcutDesc;
   }

   public String getProductName()
   {
      return this.productName;
   }

   public void setProductName(String productName)
   {
      this.productName = productName;
   }

   public BigDecimal getProductPrice()
   {
      return this.productPrice;
   }

   public void setProductPrice(BigDecimal productPrice)
   {
      this.productPrice = productPrice;
   }

}