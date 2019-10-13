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
@Table(name = "clos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CloEntity.findAll", query = "SELECT c FROM CloEntity c"),
    @NamedQuery(name = "CloEntity.findById", query = "SELECT c FROM CloEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CloEntity.findByName", query = "SELECT c FROM CloEntity c WHERE c.name = :name"),
    @NamedQuery(name = "CloEntity.findByPercentage", query = "SELECT c FROM CloEntity c WHERE c.percentage = :percentage"),
    @NamedQuery(name = "CloEntity.findByCreateTime", query = "SELECT c FROM CloEntity c WHERE c.createTime = :createTime"),
    @NamedQuery(name = "CloEntity.findByUpdateTime", query = "SELECT c FROM CloEntity c WHERE c.updateTime = :updateTime")})
public class CloEntity implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PERCENTAGE")
    private Integer percentage;
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "COURSES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private CourseEntity courseEntity;
    @OneToMany(mappedBy = "cloEntity")
    private List<ExamSectionEntity> examSectionEntityList;
    @OneToMany(mappedBy = "cloEntity")
    private List<QuestionEntity> questionEntityList;

    public CloEntity() {
    }

    public CloEntity(Integer id) {
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
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

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
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
        if (!(object instanceof CloEntity)) {
            return false;
        }
        CloEntity other = (CloEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.CloEntity[ id=" + id + " ]";
    }
     @PrePersist
	void onCreate() {
		this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onPersist() {
		this.setUpdateTime(new java.sql.Timestamp((new Date()).getTime()));
	}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<ExamSectionEntity> getExamSectionEntityList() {
        return examSectionEntityList;
    }

    public void setExamSectionEntityList(List<ExamSectionEntity> examSectionEntityList) {
        this.examSectionEntityList = examSectionEntityList;
    }

    
}
