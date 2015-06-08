/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 14, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.ItemDetails;
import com.sg.smartshop.common.helper.OrderHelper;
import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.Order;
import com.sg.smartshop.common.model.Product;
import com.sg.smartshop.common.model.User;
import com.sg.smartshop.common.service.OrderService;

/**
 * OrderController, will handle order related actions from the UI.
 *
 * @version $Id:$
 * @author rbujala (c) May 14, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/order")
public class OrderController
{
   public static Logger log = LoggerFactory.getLogger(OrderController.class);

   @Autowired
   OrderService orderService;

   @RequestMapping("/layout")
   public String getOrderPartialPage()
   {
      return "order/layout";
   }

   @RequestMapping(value = "/confirmOrderDetails", method = RequestMethod.POST)
   public @ResponseBody PojoOrder confirmOrderDetails(@RequestBody OrderHelper orderHelper)
   {
      log.info("@ Order confirm controller");      
      return orderService.addOrderDetails(orderHelper);

   }
}
