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
package com.sg.smartshop.common.helper;


/**
 * Helper class to hold the user details.
 *
 * @version $Id:$
 * @author rbujala (c) May 21, 2015, Sogeti B.V.
 */

public class UserDetails
{
   private int userId;

   private String userEmail;

   private String userFirstName;

   private String userLastName;

   private String userPassword;

   private String userName;

   private String userAddress;

   private String userCity;

   private String userPincode;

   private String userState;

   private String userType;

   /**
    * TODO
    * 
    * @return
    */
   public int getUserId()
   {
      return this.userId;
   }

   /**
    * TODO
    * 
    * @param userId
    */
   public void setUserId(int userId)
   {
      this.userId = userId;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserEmail()
   {
      return this.userEmail;
   }

   /**
    * TODO
    * 
    * @param userEmail
    */
   public void setUserEmail(String userEmail)
   {
      this.userEmail = userEmail;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserFirstName()
   {
      return this.userFirstName;
   }

   /**
    * TODO
    * 
    * @param userFirstName
    */
   public void setUserFirstName(String userFirstName)
   {
      this.userFirstName = userFirstName;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserLastName()
   {
      return this.userLastName;
   }

   /**
    * TODO
    * 
    * @param userLastName
    */
   public void setUserLastName(String userLastName)
   {
      this.userLastName = userLastName;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserPassword()
   {
      return this.userPassword;
   }

   /**
    * TODO
    * 
    * @param userPassword
    */
   public void setUserPassword(String userPassword)
   {
      this.userPassword = userPassword;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserName()
   {
      return this.userName;
   }

   /**
    * TODO
    * 
    * @param userSurname
    */
   public void setUserName(String userName)
   {
      this.userName = userName;
   }

   /**
    * Get the userAddress.
    *
    * @return Returns the userAddressLine1 as a String.
    */
   public String getUserAddress()
   {
      return userAddress;
   }

   /**
    * Set the userAddress to the specified value.
    *
    * @param userAddress The userAddressLine1 to set.
    */
   public void setUserAddress(String userAddress)
   {
      this.userAddress = userAddress;
   }

   /**
    * Get the userCity.
    *
    * @return Returns the userCity as a String.
    */
   public String getUserCity()
   {
      return userCity;
   }

   /**
    * Set the userCity to the specified value.
    *
    * @param userCity The userCity to set.
    */
   public void setUserCity(String userCity)
   {
      this.userCity = userCity;
   }

   /**
    * Get the userPincode.
    *
    * @return Returns the userPincode as a int.
    */
   public String getUserPincode()
   {
      return userPincode;
   }

   /**
    * Set the userPincode to the specified value.
    *
    * @param userPincode The userPincode to set.
    */
   public void setUserPincode(String userPincode)
   {
      this.userPincode = userPincode;
   }

   /**
    * Get the userState.
    *
    * @return Returns the userState as a String.
    */
   public String getUserState()
   {
      return userState;
   }

   /**
    * Set the userState to the specified value.
    *
    * @param userState The userState to set.
    */
   public void setUserState(String userState)
   {
      this.userState = userState;
   }

   /**
    * TODO
    * 
    * @return
    */
   public String getUserType()
   {
      return this.userType;
   }

   /**
    * TODO
    * 
    * @param userType
    */
   public void setUserType(String userType)
   {
      this.userType = userType;
   }
}