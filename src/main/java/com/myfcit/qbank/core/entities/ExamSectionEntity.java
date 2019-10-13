/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "exams_sections")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamSectionEntity.findAll", query = "SELECT e FROM ExamSectionEntity e"),
    @NamedQuery(name = "ExamSectionEntity.findById", query = "SELECT e FROM ExamSectionEntity e WHERE e.id = :id"),
    @NamedQuery(name = "ExamSectionEntity.findAllExamSectionsByExamId", query = "SELECT e FROM ExamSectionEntity e WHERE e.examEntity.id = :id"),
    @NamedQuery(name = "ExamSectionEntity.findByName", query = "SELECT e FROM ExamSectionEntity e WHERE e.name = :name"),
    @NamedQuery(name = "ExamSectionEntity.findByCreateTime", query = "SELECT e FROM ExamSectionEntity e WHERE e.createTime = :createTime")})
public class ExamSectionEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @JoinColumn(name = "CLO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private CloEntity cloEntity;
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "EXAMS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ExamEntity examEntity;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @JoinTable(name = "exams_sections_has_questions", joinColumns = {
        @JoinColumn(name = "EXAMS_SECTIONS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "QUESTIONS_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<QuestionEntity> questionEntityList;

    public ExamSectionEntity() {
    }

    public ExamSectionEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @XmlTransient
    public List<QuestionEntity> getQuestionEntityList() {
        return questionEntityList;
    }

    public void setQuestionEntityList(List<QuestionEntity> questionEntityList) {
        this.questionEntityList = questionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamSectionEntity)) {
            return false;
        }
        ExamSectionEntity other = (ExamSectionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.ExamSectionEntity[ id=" + id + " ]";
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
    }

    public ExamEntity getExamEntity() {
        return examEntity;
    }

    public void setExamEntity(ExamEntity examEntity) {
        this.examEntity = examEntity;
    }

    public CloEntity getCloEntity() {
        return cloEntity;
    }

    public void setCloEntity(CloEntity cloEntity) {
        this.cloEntity = cloEntity;
    }

    
}
