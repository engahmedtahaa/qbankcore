/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.ExamDao;
import com.myfcit.qbank.core.entities.ExamEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;


public class ExamService extends BaseService{
    
 private  ExamDao examDao ;
    
    public ExamService(EntityManager entityManager) {
        super(new ExamDao(entityManager));
        examDao = new ExamDao(entityManager);
    }  
    public List<ExamEntity> findAllLecturesExams(int lecturerId) throws QbankException {
    return examDao.findAllLecturesExams(lecturerId);
            
    }
}
