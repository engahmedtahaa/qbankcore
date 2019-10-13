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
@Table(name = "exams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamEntity.findAll", query = "SELECT e FROM ExamEntity e"),
    @NamedQuery(name = "ExamEntity.findById", query = "SELECT e FROM ExamEntity e WHERE e.id = :id"),
    @NamedQuery(name = "ExamEntity.findByName", query = "SELECT e FROM ExamEntity e WHERE e.name = :name"),
    @NamedQuery(name = "ExamEntity.findByCreateTime", query = "SELECT e FROM ExamEntity e WHERE e.createTime = :createTime"),
    @NamedQuery(name = "ExamEntity.findByinstructorId", query = "SELECT e FROM ExamEntity e WHERE e.courseEntity.userEntity.id = :id"),
    @NamedQuery(name = "ExamEntity.findByUpdateTime", query = "SELECT e FROM ExamEntity e WHERE e.updateTime = :updateTime")})
public class ExamEntity implements Serializable {
    
private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "NAME")
    private String name;
     @Column(name = "TYPE")
    private String type;
    @Column(name = "EXAM_MARK")
    private Integer examMarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examEntity")
    private List<ExamSectionEntity> examSectionEntityList;
    @JoinColumn(name = "COURSES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CourseEntity courseEntity;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
 
    public ExamEntity() {
    }

    public ExamEntity(Integer id) {
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

    @XmlTransient
    public List<ExamSectionEntity> getExamSectionEntityList() {
        return examSectionEntityList;
    }

    public void setExamSectionEntityList(List<ExamSectionEntity> examSectionEntityList) {
        this.examSectionEntityList = examSectionEntityList;
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
        if (!(object instanceof ExamEntity)) {
            return false;
        }
        ExamEntity other = (ExamEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.ExamEntity[ id=" + id + " ]";
    }
     @PrePersist
	void onCreate() {
		this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onPersist() {
		this.setUpdateTime(new java.sql.Timestamp((new Date()).getTime()));
	}

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExamMarks() {
        return examMarks;
    }

    public void setExamMarks(Integer examMarks) {
        this.examMarks = examMarks;
    }

    
    
}
