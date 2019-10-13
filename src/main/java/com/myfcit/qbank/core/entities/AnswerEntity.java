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
@Table(name = "answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerEntity.findAll", query = "SELECT a FROM AnswerEntity a"),
    @NamedQuery(name = "AnswerEntity.findById", query = "SELECT a FROM AnswerEntity a WHERE a.id = :id"),
    @NamedQuery(name = "AnswerEntity.findByValue", query = "SELECT a FROM AnswerEntity a WHERE a.value = :value"),
    @NamedQuery(name = "AnswerEntity.findByCreateTime", query = "SELECT a FROM AnswerEntity a WHERE a.createTime = :createTime"),
    @NamedQuery(name = "AnswerEntity.findByUpdateTime", query = "SELECT a FROM AnswerEntity a WHERE a.updateTime = :updateTime")})
public class AnswerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VALUE")
    private String value;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @JoinColumn(name = "QUESTIONS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private QuestionEntity questionEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answerEntity")
    private List<QuestionEntity> questionEntityList;

    public AnswerEntity() {
    }

    public AnswerEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
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
        if (!(object instanceof AnswerEntity)) {
            return false;
        }
        AnswerEntity other = (AnswerEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.AnswerEntity[ id=" + id + " ]";
    }
    
    @PrePersist
	void onCreate() {
		this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onPersist() {
		this.setUpdateTime(new java.sql.Timestamp((new Date()).getTime()));
	}
}
