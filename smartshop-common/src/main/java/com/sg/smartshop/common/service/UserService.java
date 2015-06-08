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

import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.User;

/**
 * Service class, highlight the user operations.
 *
 * @version $Id:$
 * @author rbujala (c) May 18, 2015, Sogeti B.V.
 */
public interface UserService
{
   public void addUser(User user);

   public void updateUser(User user);

   public void deleteUser(int id);

   public UserDetails findUserforAdmin(User user);

   public UserDetails findUserforUser(User user);

   public boolean isUserEmailExists(User user);
}
