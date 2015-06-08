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

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sg.smartshop.common.model.Product;
import com.sg.smartshop.common.model.User;

/**
 * implementation class of UserDao.
 *
 * @version $Id:$
 * @author rbujala (c) May 5, 2015, Sogeti B.V.
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao
{
   @PersistenceContext
   EntityManager entityManager;

   /**
    * Method, add the new user
    */
   public void addUser(User user)
   {
      entityManager.persist(user);
   }

   /**
    * Method, will update the existing user
    */
   public void updateUser(User user)
   {
      entityManager.merge(user);
   }

   /**
    * Method, delete the existing user
    */
   public void deleteUser(int id)
   {
      entityManager.remove(findById(id));
   }

   private User findById(int id)
   {
      return entityManager.find(User.class, id);
   }

   /**
    * find the existed user
    * 
    * @param user
    */
   public User findUserforUser(User user)
   {
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      CriteriaQuery<User> q = builder.createQuery(User.class);
      Root<User> root = q.from(User.class);
      q.select(root);
      q.where(builder.and(builder.equal(root.get("userEmail"), user.getUserEmail()), builder.equal(root.get("userPassword"), user.getUserPassword()), builder.equal(root.get("userType"), "U")));

      TypedQuery<User> typedQuery1 = entityManager.createQuery(q);
      List<User> userList = typedQuery1.getResultList();
      User userRecord = null;
      if (userList.size() > 0)
      {
         return userList.get(0);
      }
      return userRecord;

      //return userList;
   }

   /**
    * find the existed admin
    * 
    * @param user
    */
   public User findUserforAdmin(User user)
   {
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      CriteriaQuery<User> q = builder.createQuery(User.class);
      Root<User> root = q.from(User.class);
      q.select(root);
      q.where(builder.and(builder.equal(root.get("userName"), user.getUserName()), builder.equal(root.get("userPassword"), user.getUserPassword()), builder.equal(root.get("userType"), "A")));
      TypedQuery<User> typedQuery1 = entityManager.createQuery(q);
      List<User> userList = typedQuery1.getResultList();
      User userRecord = null;
      if (userList.size() > 0)
      {
         return userList.get(0);
      }
      return userRecord;
   }

   /**
    * method, will verify the email exists or not.
    */
   public boolean isUserEmailExists(User user)
   {
      boolean retVal = false;
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();

      CriteriaQuery<User> q = builder.createQuery(User.class);
      Root<User> root = q.from(User.class);
      q.select(root);

      ParameterExpression<String> p = builder.parameter(String.class);
      q.select(root).where(builder.equal(root.get("userEmail"), user.getUserEmail()));
      TypedQuery<User> typedQuery1 = entityManager.createQuery(q);
      List<User> userList = typedQuery1.getResultList();

      if (userList.size() > 0)
      {
         retVal = true;
      }
      return retVal;
   }
}
