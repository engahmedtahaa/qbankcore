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
@Table(name = "chapters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChapterEntity.findAll", query = "SELECT c FROM ChapterEntity c"),
    @NamedQuery(name = "ChapterEntity.findById", query = "SELECT c FROM ChapterEntity c WHERE c.id = :id"),
    @NamedQuery(name = "ChapterEntity.findByName", query = "SELECT c FROM ChapterEntity c WHERE c.name = :name"),
    @NamedQuery(name = "ChapterEntity.findByCreateTime", query = "SELECT c FROM ChapterEntity c WHERE c.createTime = :createTime"),
    @NamedQuery(name = "ChapterEntity.findByUpdateTime", query = "SELECT c FROM ChapterEntity c WHERE c.updateTime = :updateTime")})
public class ChapterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "COURSES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CourseEntity courseEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chapterEntity")
    private List<QuestionEntity> questionEntityList;
    @Column(name = "DESCRIPTION")
    private String description;

    public ChapterEntity() {
    }

    public ChapterEntity(Integer id) {
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
        if (!(object instanceof ChapterEntity)) {
            return false;
        }
        ChapterEntity other = (ChapterEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.ChapterEntity[ id=" + id + " ]";
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
}
