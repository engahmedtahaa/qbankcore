/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PersistenceManagerUtil {

    private static PersistenceManagerUtil instance;
    private static EntityManagerFactory emFactory;

    private PersistenceManagerUtil() {
        emFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    }

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

    public EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public void close() {
        emFactory.close();
    }

    public static synchronized PersistenceManagerUtil getInstance() {
        if (instance == null) {
            instance = new PersistenceManagerUtil();
        }
        return instance;
    }

}
