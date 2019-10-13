/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.CourseEntity;
import com.myfcit.qbank.core.entities.ExamEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ExamDao extends BaseDao<ExamEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public ExamDao(EntityManager entityManager) {
        super(ExamEntity.class);
        this.entityManager = entityManager;
    }

    public List<ExamEntity> findAllLecturesExams(int lecturerId) throws QbankException {
        TypedQuery<ExamEntity> query = entityManager.createNamedQuery("ExamEntity.findByinstructorId", ExamEntity.class)
                .setParameter("id", lecturerId);
        return query.getResultList();

    }
}
