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
 * This class holds the prodcut details, seleted by the user.
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */
public class ItemDetails
{

   private int id;

   private String name;
   
   private double price;

   private int quantity;
   
   /**
    * Get the name.
    *
    * @return Returns the name as a String.
    */
   public String getName()
   {
      return name;
   }

   /**
    * Set the name to the specified value.
    *
    * @param name The name to set.
    */
   public void setName(String name)
   {
      this.name = name;
   }

   

   /**
    * Get the id.
    *
    * @return Returns the id as a int.
    */
   public int getId()
   {
      return id;
   }

   /**
    * Set the id to the specified value.
    *
    * @param id The id to set.
    */
   public void setId(int id)
   {
      this.id = id;
   }

   /**
    * Get the price.
    *
    * @return Returns the price as a BigDecimal.
    */
   public double getPrice()
   {
      return price;
   }

   /**
    * Set the price to the specified value.
    *
    * @param price The price to set.
    */
   public void setPrice(double price)
   {
      this.price = price;
   }

   /**
    * Get the quantity.
    *
    * @return Returns the quantity as a int.
    */
   public int getQuantity()
   {
      return quantity;
   }

   /**
    * Set the quantity to the specified value.
    *
    * @param quantity The quantity to set.
    */
   public void setQuantity(int quantity)
   {
      this.quantity = quantity;
   }

}
