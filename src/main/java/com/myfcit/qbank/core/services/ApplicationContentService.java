/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.ApplicationContentDao;
import javax.persistence.EntityManager;


public class ApplicationContentService extends BaseService {
    
 private  ApplicationContentDao applicationContentDao ;
    
    public ApplicationContentService(EntityManager entityManager) {
        super(new ApplicationContentDao(entityManager));
        applicationContentDao = new ApplicationContentDao(entityManager);
    }      
}
