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
package com.sg.smartshop.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.User;
import com.sg.smartshop.common.service.UserService;

/**
 * UserController, will handle user operation.
 *
 * @version $Id:$
 * @author rbujala (c) May 12, 2015, Sogeti B.V.
 */
@Controller
@RequestMapping("/user")
public class UserController
{
   @Autowired
   UserService userService;

   //Logger logger 
   @RequestMapping("/layout")
   public String getUserPartialPage()
   {
      return "user/layout";
   }

   @RequestMapping(value = "/checkUserLogin", method = RequestMethod.POST)
   public @ResponseBody UserDetails checkUserCredentials(@RequestBody User user)
   {
      return userService.findUserforUser(user);      
   }

   @RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)
   public @ResponseBody void registerNewUser(@RequestBody User user)
   {
      userService.addUser(user);
   }

   @RequestMapping(value = "/isUserEmailExists", method = RequestMethod.POST)
   public @ResponseBody boolean isUserEmailExists(@RequestBody User user)
   {
      return userService.isUserEmailExists(user);
   }

}
