/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 12, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.controller;

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

import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.User;
import com.sg.smartshop.common.service.UserService;

/**
 * UserController, this will handle user related actions from the UI.
 *
 * @version $Id:$
 * @author rbujala (c) May 12, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/user")
public class UserController
{
   @Autowired
   private UserService userService;

   public static Logger log = LoggerFactory.getLogger(UserController.class);

   @RequestMapping("/layout")
   public String getUserPartialPage()
   {
      return "user/layout";
   }

   @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
   public @ResponseBody void addNewUser(@RequestBody User user)
   {
      log.info(":: Inside Add user ::");
      userService.addUser(user);
   }

   @RequestMapping(value = "/checkAdminUser", method = RequestMethod.POST)
   public @ResponseBody UserDetails checkUserCredentials(@RequestBody User user)
   {
      UserDetails userDetails = userService.findUserforAdmin(user);
      List<UserDetails> userList = null;
      if (userDetails != null)
      {
         userList = new ArrayList<UserDetails>();
         userList.add(userDetails);
      }
      return userDetails;
   }
}
