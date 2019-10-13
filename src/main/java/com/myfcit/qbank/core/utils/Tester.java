/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.utils;

import com.myfcit.qbank.core.dtos.LoginRequestModel;
import com.myfcit.qbank.core.entities.CloEntity;
import com.myfcit.qbank.core.entities.CourseEntity;
import com.myfcit.qbank.core.exceptions.QbankException;
import com.myfcit.qbank.core.proxy.QBankProxyFactory;
import com.myfcit.qbank.core.proxy.QBankServiceProxy;
import com.myfcit.qbank.core.proxy.QBankServiceProxyImpl;
import com.myfcit.qbank.core.proxy.QBankServiceableProxy;
import com.myfcit.qbank.core.services.CloService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Tester {

    public static void main(String[] args) {

        QBankServiceableProxy qbankServiceableProxy = new QBankProxyFactory().newInstance();
        try {
            qbankServiceableProxy.findChapterById(1);
            
            LoginRequestModel LoginRequestModel = new LoginRequestModel();
            LoginRequestModel.setPassword("1234567");
            LoginRequestModel.setUsername("admin");
            //QBankServiceableProxy qbankServiceableProxy2= QBankServiceProxy.createServiceInstance(new QBankServiceProxyImpl());
          qbankServiceableProxy.findByUsernameAndPassword(LoginRequestModel);
            
            
            qbankServiceableProxy.countAllClos();
            
            
            System.out.println("qbankServiceableProxy.countAllClos()"+qbankServiceableProxy.countAllClos());   
            
            
//            qbankServiceableProxy.countAllChapters();
            CloEntity clo = new CloEntity();
            clo.setName("testClo2");
            clo.setPercentage(888);
            clo.setDescription("test");
            qbankServiceableProxy.addClo(clo);
            //clo.setId(1);
//            
           CloEntity clo2= qbankServiceableProxy.findCloById(1);
           clo2.setPercentage(30);
           qbankServiceableProxy.updateClo(clo2);
//            qbankServiceableProxy.deleteClo(clo2);
qbankServiceableProxy.findAllLectures();
            System.out.println(qbankServiceableProxy.findAllLectures().size());
               
                CloService ss = null;
                
              
               
               
           
            qbankServiceableProxy.findAllLecturesCourses(1);
            System.out.println("j"+qbankServiceableProxy.findAllLecturesCourses(1).size());
           // System.out.println(qbankServiceableProxy.findAllLecturesCourses(2).size());

                CourseEntity r = new CourseEntity();
                r.setName("wwwww");
                List<CloEntity> cloEntityList = new ArrayList<>();
                CloEntity CloEntity= new CloEntity();
                CloEntity.setName("cloddd");
                cloEntityList.add(CloEntity);
                r.setCloEntityList(cloEntityList);
                qbankServiceableProxy.addCourse(r);
                
               qbankServiceableProxy.deleteCourse(qbankServiceableProxy.findCourseById(545445));        
                
                System.out.println(qbankServiceableProxy.countAllClourses());
                
                    
                    
            
        } catch (QbankException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
