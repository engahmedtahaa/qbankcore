/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.CloEntity;
import javax.persistence.EntityManager;

public class CloDao extends BaseDao<CloEntity>{

    private EntityManager entityManager;

    @Override
 protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public CloDao(EntityManager entityManager) {
        super(CloEntity.class);
        this.entityManager = entityManager;
    }
    
}
