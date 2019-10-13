/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;


import com.myfcit.qbank.core.dtos.LoginRequestModel;
import com.myfcit.qbank.core.entities.UserEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class UserDao extends BaseDao<UserEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public UserDao(EntityManager entityManager) {
        super(UserEntity.class);
        this.entityManager=entityManager;
        
    }

    public UserEntity findByFirtName() throws QbankException {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery("Country.findAll", UserEntity.class);
        return query.getSingleResult();
    }

    public UserEntity findByUserName(String userName) throws QbankException {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery("UserEntity.findByUsername", UserEntity.class)
                .setParameter("username", userName);
        return query.getSingleResult();
    }

    public UserEntity findByUsernameAndPassword(LoginRequestModel loginRequestModel) throws QbankException {
        TypedQuery<UserEntity> query = getEntityManager().createNamedQuery("UserEntity.findByUsernameAndPassword", UserEntity.class)
                .setParameter("username", loginRequestModel.getUsername())
                .setParameter("password", loginRequestModel.getPassword());
        return query.getSingleResult();
    }

    public List<UserEntity> findAllLectures() throws QbankException {
        TypedQuery<UserEntity> query = getEntityManager()
                .createNamedQuery("UserEntity.findAllLecturers", UserEntity.class)
                .setParameter("role_id", 1);
        return query.getResultList();
    }

}
