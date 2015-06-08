/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 4, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.common.dao;

import com.sg.smartshop.common.model.User;


/**
 * This will highlight the user operations
 *
 * @version $Id:$
 * @author rbujala (c) May 4, 2015, Sogeti B.V.
 */
public interface UserDao
{
   public void addUser(User user);
   
   public void updateUser(User user);
   
   public void deleteUser(int id);
   
   public User findUserforAdmin(User user);
   
   public User findUserforUser(User user);
   
   public boolean isUserEmailExists(User user);
}
