/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.UserDao;
import com.myfcit.qbank.core.dtos.LoginRequestModel;
import com.myfcit.qbank.core.entities.UserEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;

public class UserService extends BaseService {

    private UserDao userDao;

    public UserService(EntityManager entityManager) {
        super(new UserDao(entityManager));
        userDao = new UserDao(entityManager);
    }

    public UserEntity findByUsernameAndPassword(LoginRequestModel loginRequestModel) throws QbankException {
        return userDao.findByUsernameAndPassword(loginRequestModel);
    }

    public List<UserEntity> findAllLectures() throws QbankException {
        return userDao.findAllLectures();
    }

    public UserEntity findByUsername(String useName) throws QbankException {
        return userDao.findByUserName(useName);
    }
}
