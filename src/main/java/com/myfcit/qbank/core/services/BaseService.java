/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.GenericDao;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;


public class BaseService<T> implements GenericServiceable<T> {

    protected GenericDao<T> genricDao;

    public BaseService(GenericDao<T> genricDao) {
        this.genricDao = genricDao;
    }

    @Override
    public void create(T entity)throws QbankException {
        genricDao.create(entity);
    }

    @Override
    public void edit(T entity) throws QbankException{
        genricDao.edit(entity);
    }

    @Override
    public void remove(T entity)throws QbankException {
        genricDao.remove(entity);
    }

    @Override
    public T findById(Object id) throws QbankException{
        return genricDao.findById(id);
    }

    @Override
    public List<T> findAll()throws QbankException {
        return genricDao.findAll();
    }

    @Override
    public List<T> findRange(int[] range)throws QbankException {
        return genricDao.findRange(range);
    }

    @Override
    public int count()throws QbankException {
        return genricDao.count();
    }

}
