/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.AnswerDao;
import javax.persistence.EntityManager;


public class AnswerService extends BaseService{
    
    private AnswerDao answerDao ;

    public AnswerService(EntityManager entityManager) {
        super(new AnswerDao(entityManager));
        answerDao = new AnswerDao(entityManager);
    }
    
}
