/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;


import com.myfcit.qbank.core.exceptions.QbankException;
import com.myfcit.qbank.core.exceptions.QbankExceptionUtil;
import com.myfcit.qbank.core.logs.QbankLogger;
import com.myfcit.qbank.core.logs.QbankLoggerFactory;
import java.util.List;
import org.apache.log4j.Level;
import javax.persistence.EntityManager;


/**
 *
 * @param <T>
 */
public abstract  class BaseDao<T> implements GenericDao<T> {

    private final Class<T> entityClass;
    protected QbankLogger qbankLogger = QbankLoggerFactory.getLogger();
    // @PersistenceContext (unitName = "com.myfcit.qbank.core_qbankcore_jar_v1.0PU")
     protected abstract EntityManager getEntityManager();


    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) throws QbankException {
        try {
            getEntityManager().persist(entity);
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }

    }

    @Override
    public void edit(T entity) throws QbankException {
        try {
            getEntityManager().merge(entity); 
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }

    }

    @Override
    public void remove(T entity) throws QbankException {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }
    }

    @Override
    public T findById(Object id) throws QbankException {
        try {
           return getEntityManager().find(entityClass, id);
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }
    }

    @Override
    public List<T> findAll() throws QbankException {
        try {
            EntityManager em =getEntityManager();
            javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return em.createQuery(cq).getResultList();
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }
    }

    @Override
    public List<T> findRange(int[] range) throws QbankException {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws QbankException {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception ex) {
            qbankLogger.log(Level.ERROR, ex);
            throw new QbankException(QbankExceptionUtil.DAO_EXCEPTION, ex.getMessage(), ex);
        }
    }
    
}
