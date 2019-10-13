/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.HvcloDao;
import com.myfcit.qbank.core.entities.HvcloEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;


public class HvcloService extends BaseService{
    
   private  HvcloDao hvcloDao ;
    
    public HvcloService(EntityManager entityManager) {
        super(new HvcloDao(entityManager));
        hvcloDao = new HvcloDao(entityManager);
    }    
    public List<HvcloEntity> findHvcloByCourseId(int courseId) throws QbankException{
    return hvcloDao.findHvcloByCourseId(courseId);
    }
}
