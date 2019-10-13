/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.services;

import com.myfcit.qbank.core.daos.CourseDao;
import com.myfcit.qbank.core.entities.CourseEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import java.util.List;
import javax.persistence.EntityManager;



public class CourseService extends BaseService {

    private  CourseDao courseDao ;

    public CourseService(EntityManager entityManager) {
        super(new CourseDao(entityManager));
        courseDao = new CourseDao(entityManager);
    }

    public CourseEntity findByCourseName(Object courseName) throws QbankException {
        return courseDao.findByCourseName(courseName);
    }

    public List<CourseEntity> findAllLecturesCourses(int lecturerId) throws QbankException {
        return courseDao.findAllLecturesCourses(lecturerId);
    }

}
