/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.QuestionTypeDao;
import javax.persistence.EntityManager;


public class QuestionTypeService extends BaseService{
    private  QuestionTypeDao questionTypeDao ;
    
    public QuestionTypeService(EntityManager entityManager) {
        super(new QuestionTypeDao(entityManager));
        questionTypeDao = new QuestionTypeDao(entityManager);
    }   
}
