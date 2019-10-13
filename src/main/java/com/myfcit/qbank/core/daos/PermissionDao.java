/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.PermissionEntity;
import javax.persistence.EntityManager;


public class PermissionDao extends BaseDao<PermissionEntity>{

    private EntityManager entityManager;

   @Override
 protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public PermissionDao(EntityManager entityManager) {
        super(PermissionEntity.class);
        this.entityManager = entityManager;
    }
    
}
