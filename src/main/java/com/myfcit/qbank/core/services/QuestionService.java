/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.QuestionDao;
import com.myfcit.qbank.core.dtos.QuestionFilterRequestModel;
import com.myfcit.qbank.core.entities.QuestionEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;


public class QuestionService extends BaseService {

    private QuestionDao questionDao;

    public QuestionService(EntityManager entityManager) {
        super(new QuestionDao(entityManager));
        questionDao = new QuestionDao(entityManager);
    }

    public List<QuestionEntity> findAllQuestionByCourseId(int courseId) throws QbankException {
        return questionDao.findAllQuestionByCourseId(courseId);
    }

    public List<QuestionEntity> searchForQuestions(QuestionFilterRequestModel questionFilterRequestModel) throws QbankException {
        return questionDao.searchForQuestions(questionFilterRequestModel);
    }

}
