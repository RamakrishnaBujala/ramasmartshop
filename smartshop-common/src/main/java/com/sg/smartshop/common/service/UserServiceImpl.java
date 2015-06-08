/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 18, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.smartshop.admin.common.util.MappingToPojo;
import com.sg.smartshop.common.dao.UserDao;
import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.User;

/**
 * UserServiceImpl, is the implementation class of UserService
 *
 * @version $Id:$
 * @author rbujala (c) May 18, 2015, Sogeti B.V.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
   @Autowired
   private UserDao userDao;

   /**
    * User persistent in Database
    */
   public void addUser(User user)
   {
      //Setting user type as U as request from Public portal
      user.setUserType("U");
      userDao.addUser(user);
      
   }

   /**
    * Update the existed user
    */
   public void updateUser(User user)
   {
     userDao.updateUser(user);
      
   }

   /**
    * Delete the existed user
    */
   public void deleteUser(int id)
   {
      userDao.deleteUser(id);      
      
   }

  /**
   * Admin authentciation
   */
   public UserDetails findUserforAdmin(User user)
   {
      return MappingToPojo.getUserDetails(userDao.findUserforAdmin(user));
   }

   /**
       User authentciation
    */
   public UserDetails findUserforUser(User user)
   {
      
      return MappingToPojo.getUserDetails(userDao.findUserforUser(user));
      
   }

   /**
    * this will verify user email exist or not.
    * @return true - exist, else false.
    */
   public boolean isUserEmailExists(User user)
   {
      return userDao.isUserEmailExists(user);
   }

}
