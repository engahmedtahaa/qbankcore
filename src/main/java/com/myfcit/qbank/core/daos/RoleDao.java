/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.RoleEntity;
import javax.persistence.EntityManager;


public class RoleDao extends BaseDao<RoleEntity>{

    private EntityManager entityManager;

   @Override
 protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public RoleDao(EntityManager entityManager) {
        super(RoleEntity.class);
        this.entityManager = entityManager;
    }
    
}
