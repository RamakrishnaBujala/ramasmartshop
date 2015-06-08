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
package com.sg.smartshop.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.smartshop.admin.common.util.MappingToPojo;
import com.sg.smartshop.common.dao.OrderDao;
import com.sg.smartshop.common.helper.ItemDetails;
import com.sg.smartshop.common.helper.OrderHelper;
import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.model.Order;

/**
 * OrderServiceImpl, implemenation class of OrderService
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService
{

   @Autowired
   private OrderDao orderDao;

   /**
    * Add order details
    */
   public PojoOrder addOrderDetails(OrderHelper orderhelper)
   {
      return MappingToPojo.getOrderFromModel(orderDao.addOrderDetails(orderhelper));
   }

   /**
    * get order details based on the id.
    */
   public Order getOrderDetails(int id)
   {
      return null;
   }

   /**
    * return the list of orders
    */
   public List<PojoOrder> getAllOrders()
   {
      return MappingToPojo.getOrderListFromModel(orderDao.getAllOrders());
   }

   /**
    * update the order here
    */
   public void updateOrder(Order order)
   {
      orderDao.updateOrder(order);
   }
   
   /**
    * return the order details for the transaction id.
    */
   public PojoOrder getOrderDetailsByTx(String txnId)
   {
     return MappingToPojo.getOrderFromModel(orderDao.getOrderDetailsByTx(txnId));
   }
}
