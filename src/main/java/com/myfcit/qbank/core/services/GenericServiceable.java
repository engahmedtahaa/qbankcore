/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;


public interface GenericServiceable<T> {

    public void create(T entity)throws QbankException;

    public void edit(T entity)throws QbankException;

    public void remove(T entity)throws QbankException;

    public T findById(Object id)throws QbankException;

    public List<T> findAll()throws QbankException;

    public List<T> findRange(int[] range)throws QbankException;

    public int count()throws QbankException;
}
