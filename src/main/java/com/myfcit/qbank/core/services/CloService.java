/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.CloDao;
import javax.persistence.EntityManager;


public class CloService extends BaseService {

    private  CloDao cloDao ;

    public CloService(EntityManager entityManager) {
        super(new CloDao(entityManager));
        cloDao = new CloDao(entityManager);
    }

}
