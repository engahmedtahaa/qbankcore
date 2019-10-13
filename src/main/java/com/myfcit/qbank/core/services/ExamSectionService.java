/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.ExamSectionDao;
import com.myfcit.qbank.core.entities.ExamSectionEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;


public class ExamSectionService extends BaseService {

    private static ExamSectionDao examSectionDao;

    public ExamSectionService(EntityManager entityManager) {
        super(new ExamSectionDao(entityManager));
        examSectionDao = new ExamSectionDao(entityManager);
    }

    public List<ExamSectionEntity> findAllExamSectionsByExamId(int examId) throws QbankException {
        return examSectionDao.findAllExamSectionsByExamId(examId);
    }
}
