/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.HvcloEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class HvcloDao extends BaseDao<HvcloEntity>{

    private EntityManager entityManager;

    @Override
 protected EntityManager getEntityManager() {
        return entityManager;  
    }
    public HvcloDao(EntityManager entityManager) {
        super(HvcloEntity.class);
        this.entityManager = entityManager;
    }
    
    public List<HvcloEntity> findHvcloByCourseId(int courseId)throws QbankException {
        TypedQuery<HvcloEntity> query = getEntityManager().createNamedQuery("HvcloEntity.findByCoursesId", HvcloEntity.class)
                .setParameter("coursesId", courseId);
        return query.getResultList();
    }
    
}
