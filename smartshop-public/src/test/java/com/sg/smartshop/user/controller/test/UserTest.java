package com.sg.smartshop.user.controller.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sg.smartshop.common.dao.OrderDao;
import com.sg.smartshop.common.dao.UserDao;
import com.sg.smartshop.common.model.User;

/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 28, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */

/**
 * Test cases for User operations.
 *
 * @version $Id:$
 * @author rbujala (c) May 28, 2015, Sogeti B.V.
 */
@ContextConfiguration(locations = { "classpath:spring-dao.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest
{
   @Autowired
   private UserDao userDao;

   @Autowired
   private OrderDao orderDao;

   private static User user = null;

   @BeforeClass
   public static void setUp() throws Exception
   {
      user = new User();
      //user.setUserId(1);
      user.setUserFirstName("test");
      user.setUserLastName("test");
      user.setUserName("test");
      user.setUserAddress("psn");
      user.setUserCity("test");
      user.setUserPincode("12345");
      user.setUserState("KA");
      user.setUserPassword("test");
      user.setUserEmail("test@gmail.com");
      user.setUserPassword("12345");
      user.setUserType("U");
   }

   @After
   public void tearDown() throws Exception
   {
   }

   @Test
   public void testAUserInsertion() throws SQLException
   {
      userDao.addUser(user);

   }

   @Test
   public void testBUserEmailExist() throws SQLException
   {
      assertTrue(userDao.isUserEmailExists(user));

   }

   @Test
   public void testCUserRole() throws SQLException
   {
      User existedUser = userDao.findUserforUser(user);
      assertEquals("test", existedUser.getUserFirstName());

      //finally delete the test user
      userDao.deleteUser(existedUser.getUserId());

   }

}
