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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sg.smartshop.common.model.Category;
import com.sg.smartshop.common.model.Product;

/**
 * implementation class of CategroyDao, where class can insert/update and delete the categories.
 *
 * @version $Id:$
 * @author rbujala (c) May 4, 2015, Sogeti B.V.
 */
@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao
{
   public static Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);
   
   @PersistenceContext
   private EntityManager entityManager;

   /*
    * //NOTE this is a new method and has been added for test public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }
    */

   //storing category values in cache
   private List<Category> categoryListCache = new ArrayList<Category>();

   /**
    * get all the categories.
    */
   @SuppressWarnings("unchecked")
   public List<Category> getAllCategories()
   {
      if (categoryListCache.size() < 1)
      {
         return updateCategoryList();
      }
      else
      {
         return categoryListCache;
      }

   }

   /**
    * add new category
    */
   public void addCategory(Category category)
   {
      log.info(":: Add category :: " );
      entityManager.persist(category);

      //update the catergory cache
      updateCategoryList();
   }

   /**
    * update the existed category
    */
   public void updateCategory(Category category)
   {
      log.info(":: update category :: " );
      entityManager.merge(category);

      //update the catergory cache
      updateCategoryList();

   }

   /**
    * delete the existed category
    */
   public void deleteCategory(int id)
   {
      entityManager.remove(findCategoryById(id));

      //update the catergory cache
      updateCategoryList();
   }

   /**
    * delete all teh categories.
    */
   public void deleteAllCategories()
   {
      entityManager.remove(Category.class);

      //update the catergory cache
      updateCategoryList();
   }

   /**
    * find the category by ID.
    */
   public Category findCategoryById(int id)
   {
      return (Category) entityManager.find(Category.class, id);      
   }

   /**
    * List of products for the category ID.
    */
   public List<Product> getProductsByCategoryId(int id)
   {
      return findCategoryById(id).getProducts();
   }

   /**
    * on request, it will fetch from DB and return the list of Categroy List. TODO
    * 
    * @return
    */
   private List<Category> updateCategoryList()
   {
      log.info(":: Storing the category list in cache :: " );
      CriteriaBuilder builder = entityManager.getCriteriaBuilder();
      CriteriaQuery<Category> cQurey = builder.createQuery(Category.class);
      Root<Category> root = cQurey.from(Category.class);
      cQurey.select(root);     
      
      categoryListCache = entityManager.createQuery(cQurey).getResultList();
      log.info(":: Storing the category list in cache done! :: " );
      
      return categoryListCache;
   }

}
