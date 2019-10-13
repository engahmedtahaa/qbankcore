/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.ExamSectionEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class ExamSectionDao extends BaseDao<ExamSectionEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public ExamSectionDao(EntityManager entityManager) {
        super(ExamSectionEntity.class);
        this.entityManager = entityManager;
    }

    public List<ExamSectionEntity> findAllExamSectionsByExamId(int examId) throws QbankException {
        TypedQuery<ExamSectionEntity> query = getEntityManager()
                .createNamedQuery("ExamSectionEntity.findAllExamSectionsByExamId", ExamSectionEntity.class)
                .setParameter("id", examId);
        return query.getResultList();
    }

}
