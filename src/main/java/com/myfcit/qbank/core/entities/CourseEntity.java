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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "courses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseEntity.findAll", query = "SELECT c FROM CourseEntity c"),
    @NamedQuery(name = "CourseEntity.findById", query = "SELECT c FROM CourseEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CourseEntity.findByName", query = "SELECT c FROM CourseEntity c WHERE c.name = :name"),
    @NamedQuery(name = "CourseEntity.findAllLecturerCourses", query = "SELECT c FROM CourseEntity c WHERE c.userEntity.id = :id"),
    @NamedQuery(name = "CourseEntity.findByCreateTime", query = "SELECT c FROM CourseEntity c WHERE c.createTime = :createTime"),
    @NamedQuery(name = "CourseEntity.findByUpdateTime", query = "SELECT c FROM CourseEntity c WHERE c.updateTime = :updateTime")})
public class CourseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseEntity")
    private List<ExamEntity> examEntityList;
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "USERS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private UserEntity userEntity;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseEntity")
    private List<CloEntity> cloEntityList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseEntity")
    private List<ChapterEntity> chapterEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseEntity")
    private List<QuestionEntity> questionEntityList;

    public CourseEntity() {
    }

    public CourseEntity(Integer id) {
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @XmlTransient
    public List<CloEntity> getCloEntityList() {
        return cloEntityList;
    }

    public void setCloEntityList(List<CloEntity> cloEntityList) {
        this.cloEntityList = cloEntityList;
    }

    @XmlTransient
    public List<ChapterEntity> getChapterEntityList() {
        return chapterEntityList;
    }

    public void setChapterEntityList(List<ChapterEntity> chapterEntityList) {
        this.chapterEntityList = chapterEntityList;
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
        if (!(object instanceof CourseEntity)) {
            return false;
        }
        CourseEntity other = (CourseEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.CourseEntity[ id=" + id + " ]";
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setUpdateTime(new java.sql.Timestamp((new Date()).getTime()));
    }


    @XmlTransient
    public List<ExamEntity> getExamEntityList() {
        return examEntityList;
    }

    public void setExamEntityList(List<ExamEntity> examEntityList) {
        this.examEntityList = examEntityList;
    }

    
}
