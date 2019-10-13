/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.PermissionDao;
import javax.persistence.EntityManager;


public class PermissionService extends BaseService {

    private  PermissionDao permissionDao ;
    public PermissionService(EntityManager entityManager) {
        super(new PermissionDao(entityManager));
        permissionDao = new PermissionDao(entityManager);
    }
    
}
