/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.proxy;

import com.myfcit.qbank.core.dals.BaseDal;
import com.myfcit.qbank.core.exceptions.QbankException;
import com.myfcit.qbank.core.exceptions.QbankExceptionUtil;
import com.myfcit.qbank.core.logs.QbankLogger;
import com.myfcit.qbank.core.logs.QbankLoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.persistence.EntityManager;
import org.apache.log4j.Level;


public class QBankServiceProxy implements InvocationHandler {

    private EntityManager entityManager;
    private QBankServiceableProxy qBankServiceableProxy;
    private QbankLogger logger = QbankLoggerFactory.getLogger();

    private QBankServiceProxy(QBankServiceableProxy qBankServiceableProxy) {
        this.qBankServiceableProxy = qBankServiceableProxy;

    }

    public static QBankServiceableProxy createServiceInstance(QBankServiceableProxy qBankServiceableProxy) {
        EntityManager entityManager = BaseDal.getEntityManagerFactory().createEntityManager();

        return (QBankServiceableProxy) Proxy.newProxyInstance(qBankServiceableProxy.getClass().getClassLoader(), qBankServiceableProxy.getClass().getInterfaces(), new QBankServiceProxy(qBankServiceableProxy));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        BaseDal baseDal = BaseDal.getInstance();
        try {
            logger.log(Level.INFO, "**Exceute Method*** ==> "+method.getName());
            if (!((QBankServiceProxyImpl) qBankServiceableProxy).getEntityManager().isOpen()) {
                ((QBankServiceProxyImpl) qBankServiceableProxy).setEntityManager(baseDal.getEntityManager());
            }
            baseDal.beginTransaction(((QBankServiceProxyImpl) qBankServiceableProxy).getEntityManager());
            result = method.invoke(qBankServiceableProxy, args);
            baseDal.commitTransaction(((QBankServiceProxyImpl) qBankServiceableProxy).getEntityManager());
        } catch (QbankException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            baseDal.rollBackTransaction(((QBankServiceProxyImpl) qBankServiceableProxy).getEntityManager());
             logger.log(Level.ERROR, "Error During Exceuting", ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        } finally {
            baseDal.closeResources(((QBankServiceProxyImpl) qBankServiceableProxy).getEntityManager());
        }

        return result;

    }

}
