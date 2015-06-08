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
package com.sg.smartshop.common.dao;

import java.util.List;

import com.sg.smartshop.common.helper.OrderHelper;
import com.sg.smartshop.common.model.Order;

/**
 * OrderDao, abstract methods of order details
 *
 * @version $Id:$
 * @author rbujala (c) May 5, 2015, Sogeti B.V.
 */
public interface OrderDao
{
   public Order addOrderDetails(OrderHelper orderHelper);

   public void getOrderDetails(int id);
   
   public List<Order> getAllOrders();
   
   public void updateOrder(Order order);
   
   public Order getOrderDetailsByTx (String txnId);
}
