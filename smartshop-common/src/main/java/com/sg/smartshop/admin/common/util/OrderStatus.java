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
package com.sg.smartshop.admin.common.util;

import com.sg.smartshop.common.model.Order;

/**
 * Enum class for order status.
 *
 * @version $Id:$
 * @author rbujala (c) Jun 4, 2015, Sogeti B.V.
 */
public enum OrderStatus
{
   P("PLACED"), D("DELIVERED"), C("CANCELLED");

   private String statusCode;

   private OrderStatus(String status)
   {
      statusCode = status;
   }

   public String getStatusCode()
   {
      return statusCode;
   }
}
