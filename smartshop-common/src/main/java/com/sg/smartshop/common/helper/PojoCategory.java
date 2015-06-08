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

/**
 * Helper class for the category model.
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */

public class PojoCategory
{
   private int categoryId;

   private String categoryDescription;

   private String categoryName;

   public int getCategoryId()
   {
      return this.categoryId;
   }

   public void setCategoryId(int categoryId)
   {
      this.categoryId = categoryId;
   }

   public String getCategoryDescription()
   {
      return this.categoryDescription;
   }

   public void setCategoryDescription(String categoryDescription)
   {
      this.categoryDescription = categoryDescription;
   }

   public String getCategoryName()
   {
      return this.categoryName;
   }

   public void setCategoryName(String categoryName)
   {
      this.categoryName = categoryName;
   }

}