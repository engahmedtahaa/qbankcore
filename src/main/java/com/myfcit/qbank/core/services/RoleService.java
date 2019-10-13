/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.RoleDao;
import javax.persistence.EntityManager;


public class RoleService extends BaseService{
    
 private  RoleDao roleDao ;
    
    public RoleService(EntityManager entityManager) {
        super(new RoleDao(entityManager));
        roleDao = new RoleDao(entityManager);
    }   
}
