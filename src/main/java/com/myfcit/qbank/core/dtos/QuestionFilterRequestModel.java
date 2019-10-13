/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.dtos;


public class QuestionFilterRequestModel {
    private int clo;
    private int hvclo;
    private int questionType;
    private int section;
    private int chapter;
    private int courseId;

    public int getClo() {
        return clo;
    }

    public void setClo(int clo) {
        this.clo = clo;
    }

    public int getHvclo() {
        return hvclo;
    }

    public void setHvclo(int hvclo) {
        this.hvclo = hvclo;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

  
    
}
