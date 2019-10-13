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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionEntity.findAll", query = "SELECT q FROM QuestionEntity q"),
    @NamedQuery(name = "QuestionEntity.findById", query = "SELECT q FROM QuestionEntity q WHERE q.id = :id"),
    @NamedQuery(name = "QuestionEntity.findAllQuestionByCourseId", query = "SELECT q FROM QuestionEntity q WHERE q.courseEntity.id = :id"),
    @NamedQuery(name = "QuestionEntity.searchForQuestions", query = "SELECT q FROM QuestionEntity q WHERE q.courseEntity.id = :courseId and q.chapterEntity.id=:chapterId and q.cloEntity.id=:cloid and q.questionTypeEntity.id=:questionTypeId"),
    @NamedQuery(name = "QuestionEntity.findByCreateTime", query = "SELECT q FROM QuestionEntity q WHERE q.createTime = :createTime"),
    @NamedQuery(name = "QuestionEntity.findByUpdateTime", query = "SELECT q FROM QuestionEntity q WHERE q.updateTime = :updateTime"),
    @NamedQuery(name = "QuestionEntity.findByStudentLearningOutcome", query = "SELECT q FROM QuestionEntity q WHERE q.studentLearningOutcome = :studentLearningOutcome"),
    @NamedQuery(name = "QuestionEntity.findByLearingOutcomeDomain", query = "SELECT q FROM QuestionEntity q WHERE q.learingOutcomeDomain = :learingOutcomeDomain")})
public class QuestionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Lob
    @Column(name = "VALUE")
    private String value;
    @Column(name = "TAXONOMY_BLOOM")
    private String taxonomyBloom;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "STUDENT_LEARNING_OUTCOME")
    private String studentLearningOutcome;
    @Column(name = "LEARING_OUTCOME_DOMAIN")
    private String learingOutcomeDomain;
    @ManyToMany(mappedBy = "questionEntityList")
    private List<ExamSectionEntity> examSectionEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionEntity")
    private List<AnswerEntity> answerEntityList;
    @JoinColumn(name = "CORRECT_ANSWERS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private AnswerEntity answerEntity;
    @JoinColumn(name = "CHAPTERS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ChapterEntity chapterEntity;
    @JoinColumn(name = "CLOS_ID", referencedColumnName = "ID")
    @ManyToOne
    private CloEntity cloEntity;
    @JoinColumn(name = "COURSES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CourseEntity courseEntity;
    @JoinColumn(name = "QUESTIONS_TYPES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QuestionTypeEntity questionTypeEntity;

    public QuestionEntity() {
    }

    public QuestionEntity(Integer id) {
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

    public String getStudentLearningOutcome() {
        return studentLearningOutcome;
    }

    public void setStudentLearningOutcome(String studentLearningOutcome) {
        this.studentLearningOutcome = studentLearningOutcome;
    }

    public String getLearingOutcomeDomain() {
        return learingOutcomeDomain;
    }

    public void setLearingOutcomeDomain(String learingOutcomeDomain) {
        this.learingOutcomeDomain = learingOutcomeDomain;
    }

    @XmlTransient
    public List<ExamSectionEntity> getExamSectionEntityList() {
        return examSectionEntityList;
    }

    public void setExamSectionEntityList(List<ExamSectionEntity> examSectionEntityList) {
        this.examSectionEntityList = examSectionEntityList;
    }

    @XmlTransient
    public List<AnswerEntity> getAnswerEntityList() {
        return answerEntityList;
    }

    public void setAnswerEntityList(List<AnswerEntity> answerEntityList) {
        this.answerEntityList = answerEntityList;
    }

    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }

    public ChapterEntity getChapterEntity() {
        return chapterEntity;
    }

    public void setChapterEntity(ChapterEntity chapterEntity) {
        this.chapterEntity = chapterEntity;
    }

    public CloEntity getCloEntity() {
        return cloEntity;
    }

    public void setCloEntity(CloEntity cloEntity) {
        this.cloEntity = cloEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    public QuestionTypeEntity getQuestionTypeEntity() {
        return questionTypeEntity;
    }

    public void setQuestionTypeEntity(QuestionTypeEntity questionTypeEntity) {
        this.questionTypeEntity = questionTypeEntity;
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
        if (!(object instanceof QuestionEntity)) {
            return false;
        }
        QuestionEntity other = (QuestionEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myfcit.qbank.core.entities.QuestionEntity[ id=" + id + " ]";
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(new java.sql.Timestamp((new Date()).getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setUpdateTime(new java.sql.Timestamp((new Date()).getTime()));
    }

    public String getTaxonomyBloom() {
        return taxonomyBloom;
    }

    public void setTaxonomyBloom(String taxonomyBloom) {
        this.taxonomyBloom = taxonomyBloom;
    }

}
