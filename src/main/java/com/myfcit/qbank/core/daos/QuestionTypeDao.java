/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.QuestionTypeEntity;
import javax.persistence.EntityManager;


public class QuestionTypeDao extends BaseDao<QuestionTypeEntity>{
    
private EntityManager entityManager;

    @Override
  protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public QuestionTypeDao(EntityManager entityManager) {
        super(QuestionTypeEntity.class);
        this.entityManager = entityManager;
    }
    
}
