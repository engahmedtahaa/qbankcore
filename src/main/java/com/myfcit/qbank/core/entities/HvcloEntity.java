/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfcit.qbank.core.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "hvclo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HvcloEntity.findAll", query = "SELECT h FROM HvcloEntity h"),
    @NamedQuery(name = "HvcloEntity.findById", query = "SELECT h FROM HvcloEntity h WHERE h.id = :id"),
    @NamedQuery(name = "HvcloEntity.findByName", query = "SELECT h FROM HvcloEntity h WHERE h.name = :name"),
    @NamedQuery(name = "HvcloEntity.findByPercentage", query = "SELECT h FROM HvcloEntity h WHERE h.percentage = :percentage"),
    @NamedQuery(name = "HvcloEntity.findByCoursesId", query = "SELECT h FROM HvcloEntity h WHERE h.coursesId = :coursesId"),
    @NamedQuery(name = "HvcloEntity.findByCreateTime", query = "SELECT h FROM HvcloEntity h WHERE h.createTime = :createTime"),
    @NamedQuery(name = "HvcloEntity.findByUpdateTime", query = "SELECT h FROM HvcloEntity h WHERE h.updateTime = :updateTime")})
public class HvcloEntity implements Serializable {

    @Basic(optional = false)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PERCENTAGE")
    private Integer percentage;
    @Column(name = "COURSES_ID")
    private Integer coursesId;
    @Column(name = "DESCRIPTION")
    private String description;
    private static final long serialVersionUID = 1L;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public HvcloEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(int coursesId) {
        this.coursesId = coursesId;
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

    public void setCoursesId(Integer coursesId) {
        this.coursesId = coursesId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
