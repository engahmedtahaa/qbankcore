/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.dals;

import com.myfcit.qbank.core.exceptions.QbankException;
import com.myfcit.qbank.core.exceptions.QbankExceptionUtil;
import com.myfcit.qbank.core.logs.QbankLogger;
import com.myfcit.qbank.core.logs.QbankLoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.apache.log4j.Level;


public class BaseDal {

    private static BaseDal instance;
    private static EntityManagerFactory emFactory;
    private EntityManager entityManager;
    protected QbankLogger qbankLogger = QbankLoggerFactory.getLogger();

    private BaseDal() {
        emFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    }

    public static synchronized EntityManagerFactory getEntityManagerFactory() {
        return emFactory;
    }

    public EntityManager getEntityManager() {
        entityManager = emFactory.createEntityManager();
        return entityManager;
    }

    public void close() {
        emFactory.close();
    }

    public static synchronized BaseDal getInstance() {
        if (instance == null) {
            instance = new BaseDal();
        }
        return instance;
    }

    public void beginTransaction(EntityManager entityManager) throws QbankException {
        try {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.getTransaction().begin();
            }
        } catch (Exception e) {
            qbankLogger.log(Level.ERROR, e);
            throw new QbankException(QbankExceptionUtil.IILEGAL_STATE_EXCEPTION, e.getMessage(), e);

        }
    }

    public void commitTransaction(EntityManager entityManager) throws QbankException {
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().commit();
           }
        } catch (Exception e) {
            qbankLogger.log(Level.ERROR, e);
            throw new QbankException(QbankExceptionUtil.IILEGAL_STATE_EXCEPTION, e.getMessage(), e);

        }
    }

    public void rollBackTransaction(EntityManager entityManager) throws QbankException {
        try {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
        } catch (IllegalStateException | PersistenceException e) {
            qbankLogger.log(Level.ERROR, e);
            throw new QbankException(QbankExceptionUtil.IILEGAL_STATE_EXCEPTION, e.getMessage(), e);

        }
    }

    public void closeResources(EntityManager entityManager) throws QbankException {
        try {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        } catch (IllegalStateException | PersistenceException e) {
            qbankLogger.log(Level.ERROR, e);
            throw new QbankException(QbankExceptionUtil.IILEGAL_STATE_EXCEPTION, e.getMessage(), e);
        }
    }

}
