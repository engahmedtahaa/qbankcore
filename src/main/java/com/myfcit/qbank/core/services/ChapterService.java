/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.ChapterDao;
import javax.persistence.EntityManager;


public class ChapterService extends BaseService {

    private ChapterDao chapterDao;

    public ChapterService(EntityManager entityManager) {
        super(new ChapterDao(entityManager));
        chapterDao = new ChapterDao(entityManager);
    }

}
