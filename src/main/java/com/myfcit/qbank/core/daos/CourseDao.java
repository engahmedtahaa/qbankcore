/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.daos;

import com.myfcit.qbank.core.entities.CourseEntity;

import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class CourseDao extends BaseDao<CourseEntity> {

    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public CourseDao(EntityManager entityManager) {
        super(CourseEntity.class);
        this.entityManager = entityManager;
    }

    public CourseEntity findByCourseName(Object courseName) throws QbankException {

        TypedQuery<CourseEntity> query = entityManager.createNamedQuery("CourseEntity.findByName", CourseEntity.class)
                .setParameter("name", courseName);
        return query.getSingleResult();

    }

    public List<CourseEntity> findAllLecturesCourses(int lecturerId) throws QbankException {

        TypedQuery<CourseEntity> query = entityManager.createNamedQuery("CourseEntity.findAllLecturerCourses", CourseEntity.class)
                .setParameter("id", lecturerId);
        return query.getResultList();

    }

}
