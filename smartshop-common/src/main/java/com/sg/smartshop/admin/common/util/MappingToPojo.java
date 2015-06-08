/*------------------------------------------------------------------------------
 **     Ident: Delivery Center Java
 **    Author: rbujala
 ** Copyright: (c) May 6, 2015 Sogeti Nederland B.V. All Rights Reserved.
 **------------------------------------------------------------------------------
 ** Sogeti Nederland B.V.            |  No part of this file may be reproduced  
 ** Distributed Software Engineering |  or transmitted in any form or by any        
 ** Lange Dreef 17                   |  means, electronic or mechanical, for the      
 ** 4131 NJ Vianen                   |  purpose, without the express written    
 ** The Netherlands                  |  permission of the copyright holder.
 *------------------------------------------------------------------------------
 */
package com.sg.smartshop.admin.common.util;

import java.util.ArrayList;
import java.util.List;

import com.sg.smartshop.common.helper.PojoCategory;
import com.sg.smartshop.common.helper.PojoOrder;
import com.sg.smartshop.common.helper.PojoProduct;
import com.sg.smartshop.common.helper.UserDetails;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Order;
import com.sg.smartshop.common.model.Product;
import com.sg.smartshop.common.model.User;

/**
 * This is helper class from service layer to Dao.
 *
 * @version $Id:$
 * @author rbujala (c) May 6, 2015, Sogeti B.V.
 */
public class MappingToPojo
{
   /**
    * Get the category list. TODO
    * 
    * @param catList
    * @return
    */

   public static List<PojoCategory> getCategoryList(List<Category> catList)
   {
      List<PojoCategory> categoryList = new ArrayList<PojoCategory>();
      for (Category c : catList)
      {
         PojoCategory pojoCategory = new PojoCategory();
         pojoCategory.setCategoryId(c.getCategoryId());
         pojoCategory.setCategoryName(c.getCategoryName());
         pojoCategory.setCategoryDescription(c.getCategoryDescription());
         categoryList.add(pojoCategory);
      }
      return categoryList;
   }

   /**
    * from Model to helper class TODO
    * 
    * @param catList
    * @return
    */
   public static List<PojoProduct> getProductList(List<Product> catList)
   {
      List<PojoProduct> productList = new ArrayList<PojoProduct>();
      for (Product c : catList)
      {
         PojoProduct pojoProduct = new PojoProduct();
         pojoProduct.setProdcutId(c.getProductId());
         pojoProduct.setProductName(c.getProductName());
         pojoProduct.setProductPrice(c.getProductPrice());
         pojoProduct.setProdcutDesc(c.getProdcutDesc());
         if (c.getCategory() != null)
         {
            PojoCategory pojoCategory = new PojoCategory();
            pojoCategory.setCategoryId(c.getCategory().getCategoryId());
            pojoCategory.setCategoryDescription(c.getCategory().getCategoryDescription());
            pojoCategory.setCategoryName(c.getCategory().getCategoryName());
            pojoProduct.setCategory(pojoCategory);
         }
         productList.add(pojoProduct);
      }
      return productList;
   }

   /**
    * Get the user details TODO
    * 
    * @param userInfo
    * @return
    */
   public static UserDetails getUserDetails(User userInfo)
   {

      UserDetails pojoUser = null;
      if (userInfo != null)
      {
         pojoUser = new UserDetails();
         pojoUser.setUserName(userInfo.getUserFirstName());
         pojoUser.setUserId(userInfo.getUserId());
      }
      return pojoUser;
   }

   /**
    * This method will help to UI info to model object TODO
    * 
    * @param pojoProduct
    * @return
    */
   public static Product getModelProduct(PojoProduct pojoProduct)
   {
      Product product = null;
      if (pojoProduct != null)
      {
         product = new Product();
         product.setProductId(pojoProduct.getProdcutId());
         product.setProductName(pojoProduct.getProductName());
         product.setProdcutDesc(pojoProduct.getProdcutDesc());
         product.setProductPrice(pojoProduct.getProductPrice());
         if (pojoProduct.getCategory() != null)
         {
            Category category = new Category();
            category.setCategoryId(pojoProduct.getCategory().getCategoryId());
            product.setCategory(category);
         }
      }
      return product;
   }

   /**
    * return the list of Order Items.
    * 
    * @param orderList
    * @return
    */
   public static List<PojoOrder> getOrderListFromModel(List<Order> orderList)
   {
      List<PojoOrder> ordList = new ArrayList<PojoOrder>();
      for (Order order : orderList)
      {
         PojoOrder pojoOrder = new PojoOrder();
         pojoOrder.setOrderId(order.getOrderId());
         pojoOrder.setOrderTxnId(order.getOrderTxnId());
         pojoOrder.setOrderStatus(order.getOrderStatus());
         pojoOrder.setOrderBookingDate(order.getOrderBookingDate());
         pojoOrder.setUserId(order.getUserId());
         pojoOrder.setShippingAddress(order.getShippingAddress());
         pojoOrder.setShippingCity(order.getShippingCity());
         pojoOrder.setShippingPin(order.getShippingPin());
         pojoOrder.setOrderCancelDate(order.getOrderCancelDate());
         ordList.add(pojoOrder);
      }

      return ordList;
   }

   /**
    * return single order entity TODO
    * 
    * @param order
    * @return
    */
   public static PojoOrder getOrderFromModel(Order order)
   {
      PojoOrder pojoOrder = null;
      if (order != null)
      {
         pojoOrder = new PojoOrder();
         pojoOrder.setOrderId(order.getOrderId());
         pojoOrder.setOrderTxnId(order.getOrderTxnId());
         pojoOrder.setOrderStatus(order.getOrderStatus());
         pojoOrder.setOrderBookingDate(order.getOrderBookingDate());
         pojoOrder.setUserId(order.getUserId());
         pojoOrder.setShippingAddress(order.getShippingAddress());
         pojoOrder.setShippingCity(order.getShippingCity());
         pojoOrder.setShippingPin(order.getShippingPin());
         pojoOrder.setOrderCancelDate(order.getOrderCancelDate());
      }

      return pojoOrder;
   }
}
