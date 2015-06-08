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
package com.sg.smartshop.common.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sg.smartshop.common.helper.ItemDetails;
import com.sg.smartshop.common.helper.OrderHelper;
import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Order;
import com.sg.smartshop.common.model.OrderDetail;

/**
 * Implementation of OrderDao class.
 *
 * @version $Id:$
 * @author rbujala (c) May 5, 2015, Sogeti B.V.
 */
@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao
{
   @PersistenceContext
   private EntityManager entityManager;

   private List<Order> orderListCache = new ArrayList<Order>();

   public static Logger log = LoggerFactory.getLogger(OrderDaoImpl.class);

   /**
    * Method, add the new order details.
    */
   public Order addOrderDetails(OrderHelper orderhelper)
   {

      //iterate the list of products here
      //perpare remainig details for Order
      Order order = new Order();
      order.setOrderBookingDate(new Date());
      order.setOrderStatus('P'); //placing the order
      //current time mills will generate the random number Ex:1432210292590
      String txnId = "ORD" + System.currentTimeMillis();
      order.setOrderTxnId(txnId);
      order.setShippingAddress(orderhelper.getOrderShippingAddress());
      order.setShippingCity(orderhelper.getOrderShippingCity());
      order.setShippingPin(orderhelper.getOrderShippingPin());
      order.setUserId(orderhelper.getUserId());
      //save the order.
      //sessionFactory.getCurrentSession().save(order);
      entityManager.persist(order);

      Iterator<ItemDetails> iterator = orderhelper.getItemDetails().iterator();
      while (iterator.hasNext())
      {
         ItemDetails prod = iterator.next();
         OrderDetail detail = new OrderDetail();
         detail.setProductId(prod.getId());
         detail.setOrder(order);
         detail.setOrderDetailsQty(prod.getQuantity());
         if (prod.getQuantity() > 1)
         {
            detail.setOrderDetailsPrice((prod.getPrice() * prod.getQuantity()));
         }
         else
         {
            detail.setOrderDetailsPrice(prod.getPrice());
         }
         entityManager.persist(detail);
      }

      //return the order details to the user.
      return getOrderDetailsByTx(txnId);
   }

   /**
    * get order details based on the id.
    */
   public void getOrderDetails(int id)
   {
      // TODO Auto-generated method stub

   }

   /**
    * Method will gives the order info based on the Txnid. TODO
    * 
    * @param txnId
    * @return
    */
   public Order getOrderDetailsByTx(String txnId)
   {
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      CriteriaQuery<Order> q = builder.createQuery(Order.class);
      Root<Order> root = q.from(Order.class);
      q.select(root);
      q.where(builder.and(builder.equal(root.get("orderTxnId"), txnId)));
      TypedQuery<Order> typedQuery1 = entityManager.createQuery(q);
      List<Order> orderList = typedQuery1.getResultList();
      Order orderDetails = null;
      if (orderList.size() > 0)
      {
         orderDetails = orderList.get(0);
      }
      return orderDetails;
   }

   /**
    * getting tht list of orders booked by the user TODO
    * 
    * @return
    */
   public List<Order> getAllOrders()
   {
      log.info(":: Get All oders in DaoImpl ::");
      if (orderListCache.size() < 1)
      {
         return updateOrderList();
      }
      else
      {
         return orderListCache;
      }
   }

   /**
    * This method will return the list of orders on demand. TODO
    * 
    * @return
    */
   private List<Order> updateOrderList()
   {
      log.info(":: Storing the order list in cache :: ");
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Order> cQurey = builder.createQuery(Order.class);
      Root<Order> root = cQurey.from(Order.class);
      cQurey.select(root);

      orderListCache = entityManager.createQuery(cQurey).getResultList();
      log.info(":: Storing the order list in cache done! :: ");

      return orderListCache;
   }

   public void updateOrder(Order order)
   {
      log.info(":: order updation by Admin ::");
      if (order.getOrderStatus() == 'C')
         order.setOrderCancelDate(new Date());
      entityManager.merge(order);

      //finally upate the order cache
      updateOrderList();
   }

}
