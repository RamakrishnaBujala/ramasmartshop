/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) Jun 4, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Order;
import com.sg.smartshop.common.service.OrderService;

/**
 * Controller class for user order track.
 *
 * @version $Id:$
 * @author rbujala (c) Jun 4, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/track")
public class OrderTrackerController
{
   @Autowired
   private OrderService orderService;
   
   public static Logger log = LoggerFactory.getLogger(OrderTrackerController.class);
   
   @RequestMapping("/layout")
   public String getOrderPartialPage()
   {
      return "track/layout";
   }
   
   /*@RequestMapping(value = "/getOrderDetails/{txnId}", method = RequestMethod.POST)
   public @ResponseBody PojoOrder getOrderDetailsByTx(@PathVariable("txnId") String txnId)
   {
      return orderService.getOrderDetailsByTx(txnId);
   }*/
   
   @RequestMapping(value = "/getOrderDetails/{txnId}", method = RequestMethod.POST)
   public @ResponseBody PojoOrder getOrderDetailsByTx(@PathVariable("txnId") String txnId)
   {
      return orderService.getOrderDetailsByTx(txnId);
   }
}
