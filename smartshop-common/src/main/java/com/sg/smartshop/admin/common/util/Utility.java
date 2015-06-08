/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 5, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.common.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

/**
 * ????
 *
 * @version $Id:$
 * @author rbujala (c) May 5, 2015, Sogeti B.V.
 */
public class Utility
{
   public static String nextUUID()
   {
      return UUID.randomUUID().toString();
   }

   public static byte[] getByteArray(File file) throws IOException
   {
      BufferedImage originalImage = ImageIO.read(file);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(originalImage, "jpg", baos);
      baos.flush();
      return baos.toByteArray();
   }

}
