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

import java.util.List;

/**
 * Helper class to hold the order details by the user.
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */
public class OrderHelper
{
   private List<ItemDetails> itemDetails;

   private String orderShippingAddress;

   private String orderShippingCity;

   private String orderShippingPin;

   private int userId;

   /**
    * Get the itemDetails.
    *
    * @return Returns the itemDetails as a ItemDetails.
    */
   public List<ItemDetails> getItemDetails()
   {
      return itemDetails;
   }

   /**
    * Set the itemDetails to the specified value.
    *
    * @param itemDetails The itemDetails to set.
    */
   public void setItemDetails(List<ItemDetails> itemDetails)
   {
      this.itemDetails = itemDetails;
   }

   /**
    * Get the orderShippingAddress.
    *
    * @return Returns the orderShippingAddress as a String.
    */
   public String getOrderShippingAddress()
   {
      return orderShippingAddress;
   }

   /**
    * Set the orderShippingAddress to the specified value.
    *
    * @param orderShippingAddress The orderShippingAddress to set.
    */
   public void setOrderShippingAddress(String orderShippingAddress)
   {
      this.orderShippingAddress = orderShippingAddress;
   }

   /**
    * Get the orderShippingCity.
    *
    * @return Returns the orderShippingCity as a String.
    */
   public String getOrderShippingCity()
   {
      return orderShippingCity;
   }

   /**
    * Set the orderShippingCity to the specified value.
    *
    * @param orderShippingCity The orderShippingCity to set.
    */
   public void setOrderShippingCity(String orderShippingCity)
   {
      this.orderShippingCity = orderShippingCity;
   }

   /**
    * Get the orderShippingPin.
    *
    * @return Returns the orderShippingPin as a String.
    */
   public String getOrderShippingPin()
   {
      return orderShippingPin;
   }

   /**
    * Set the orderShippingPin to the specified value.
    *
    * @param orderShippingPin The orderShippingPin to set.
    */
   public void setOrderShippingPin(String orderShippingPin)
   {
      this.orderShippingPin = orderShippingPin;
   }

   /**
    * Get the userId.
    *
    * @return Returns the userId as a int.
    */
   public int getUserId()
   {
      return userId;
   }

   /**
    * Set the userId to the specified value.
    *
    * @param userId The userId to set.
    */
   public void setUserId(int userId)
   {
      this.userId = userId;
   }

}
