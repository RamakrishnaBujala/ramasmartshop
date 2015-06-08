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

import com.sg.smartshop.common.helper.ItemDetails;
import com.sg.smartshop.common.helper.OrderHelper;
import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.model.Order;

/**
 * Service Class highlight the Order operations
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */
public interface OrderService
{
   public PojoOrder addOrderDetails(OrderHelper orderHelper);

   public Order getOrderDetails(int id);
   
   public List<PojoOrder> getAllOrders();
   
   public void updateOrder(Order order);
   
   public PojoOrder getOrderDetailsByTx(String txnId);
}
