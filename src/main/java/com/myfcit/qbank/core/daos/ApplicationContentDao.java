/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.ApplicationContentEntity;
import javax.persistence.EntityManager;


public class ApplicationContentDao extends BaseDao<ApplicationContentEntity>{

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public ApplicationContentDao(EntityManager entityManager) {
        super(ApplicationContentEntity.class);
        this.entityManager=entityManager;
    }
    
}
