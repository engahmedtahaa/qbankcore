/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.ChapterEntity;
import javax.persistence.EntityManager;


public class ChapterDao extends BaseDao<ChapterEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public ChapterDao(EntityManager entityManager) {
        super(ChapterEntity.class);
        this.entityManager = entityManager;
    }

}
