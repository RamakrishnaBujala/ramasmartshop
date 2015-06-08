/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 19, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.helper.PojoProduct;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Order;
import com.sg.smartshop.common.model.User;
import com.sg.smartshop.common.service.OrderService;

/**
 * OrderController, order related request will handle here.
 *
 * @version $Id:$
 * @author rbujala (c) May 19, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/order")
public class OrderController
{
   
   public static Logger log = LoggerFactory.getLogger(ProductController.class);

   @Autowired
   private OrderService orderService;
   
   @RequestMapping("/orderlist.json")
   public @ResponseBody List<PojoOrder> getOrderList()
   {
      log.info("::Getting Orders list ::");
      return orderService.getAllOrders();
   }

   @RequestMapping(value = "/updateOrder", method = RequestMethod.PUT)
   public @ResponseBody void updateOrder(@RequestBody Order order)
   {
      orderService.updateOrder(order);
   }
   
   @RequestMapping("/layout")
   public String getCategoryPartialPage(ModelMap modelMap)
   {
      return "order/layout";
   }
}
