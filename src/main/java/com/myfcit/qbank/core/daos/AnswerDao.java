/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;


import com.myfcit.qbank.core.entities.AnswerEntity;
import javax.persistence.EntityManager;


public class AnswerDao extends BaseDao {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public AnswerDao(EntityManager entityManager) {
        super(AnswerEntity.class);
        this.entityManager = entityManager;
    }

}
