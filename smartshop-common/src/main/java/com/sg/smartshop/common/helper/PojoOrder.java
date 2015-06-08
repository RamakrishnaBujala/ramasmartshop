/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 5, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.helper;

import java.util.Date;

/**
 * Helper class for Order model class.
 *
 * @version $Id:$
 * @author rbujala (c) May 5, 2015, Sogeti B.V.
 */
public class PojoOrder
{
   private int orderId;
   private Date orderBookingDate;
   private Date orderCancelDate;
   private char orderStatus;
   private String orderTxnId;
   
   private int userId;
   private String shippingAddress;
   private String shippingCity;
   private String shippingPin;
   
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

   /**
    * Get the shippingAddress.
    *
    * @return Returns the shippingAddress as a String.
    */
   public String getShippingAddress()
   {
      return shippingAddress;
   }

   /**
    * Set the shippingAddress to the specified value.
    *
    * @param shippingAddress The shippingAddress to set.
    */
   public void setShippingAddress(String shippingAddress)
   {
      this.shippingAddress = shippingAddress;
   }

   /**
    * Get the shippingCity.
    *
    * @return Returns the shippingCity as a String.
    */
   public String getShippingCity()
   {
      return shippingCity;
   }

   /**
    * Set the shippingCity to the specified value.
    *
    * @param shippingCity The shippingCity to set.
    */
   public void setShippingCity(String shippingCity)
   {
      this.shippingCity = shippingCity;
   }

   /**
    * Get the shippingPin.
    *
    * @return Returns the shippingPin as a String.
    */
   public String getShippingPin()
   {
      return shippingPin;
   }

   /**
    * Set the shippingPin to the specified value.
    *
    * @param shippingPin The shippingPin to set.
    */
   public void setShippingPin(String shippingPin)
   {
      this.shippingPin = shippingPin;
   }

  
   
   
   /**
    * get order id
    * TODO
    * @return
    */
   public int getOrderId()
   {
      return this.orderId;
   }

   /**
    * set order id
    * TODO
    * @param orderId
    */
   public void setOrderId(int orderId)
   {
      this.orderId = orderId;
   }

   /**
    * get order bookig date
    * TODO
    * @return
    */
   public Date getOrderBookingDate()
   {
      return this.orderBookingDate;
   }

   /**
    * set order booking date
    * TODO
    * @param orderBookingDate
    */
   public void setOrderBookingDate(Date orderBookingDate)
   {
      this.orderBookingDate = orderBookingDate;
   }

   /**
    * get order cancel date
    * TODO
    * @return
    */
   public Date getOrderCancelDate()
   {
      return this.orderCancelDate;
   }

   /**
    * set order cancel date
    * TODO
    * @param orderCancelDate
    */
   public void setOrderCancelDate(Date orderCancelDate)
   {
      this.orderCancelDate = orderCancelDate;
   }

   public char getOrderStatus()
   {
      return this.orderStatus;
   }

   /**
    * set order status
    * TODO
    * @param orderStatus
    */
   public void setOrderStatus(char orderStatus)
   {
      this.orderStatus = orderStatus;
   }

   /**
    * get order
    * TODO
    * @return
    */
   public String getOrderTxnId()
   {
      return this.orderTxnId;
   }

   /**
    * set order
    * TODO
    * @param string
    */
   public void setOrderTxnId(String string)
   {
      this.orderTxnId = string;
   }
  

}