/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.dtos.QuestionFilterRequestModel;
import com.myfcit.qbank.core.entities.QuestionEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class QuestionDao extends BaseDao<QuestionEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public QuestionDao(EntityManager entityManager) {
        super(QuestionEntity.class);
        this.entityManager = entityManager;
    }

    public List<QuestionEntity> findAllQuestionByCourseId(int courseId) throws QbankException {
        TypedQuery<QuestionEntity> query = getEntityManager()
                .createNamedQuery("QuestionEntity.findAllQuestionByCourseId", QuestionEntity.class)
                .setParameter("id", courseId);
        return query.getResultList();
    }
    
    public List<QuestionEntity> searchForQuestions(QuestionFilterRequestModel questionFilterRequestModel) throws QbankException {
        TypedQuery<QuestionEntity> query = getEntityManager()
                .createNamedQuery("QuestionEntity.searchForQuestions", QuestionEntity.class)
                .setParameter("courseId", questionFilterRequestModel.getCourseId())
                .setParameter("chapterId", questionFilterRequestModel.getChapter())
                .setParameter("cloid", questionFilterRequestModel.getClo())
                .setParameter("questionTypeId", questionFilterRequestModel.getQuestionType());
        
        return query.getResultList();
    }

}
