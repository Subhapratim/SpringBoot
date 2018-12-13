package com.example.demo.Domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class BaseDomain implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "isActive", columnDefinition = "boolean default true")
    private boolean isActive = true;

    @CreationTimestamp
    @Temporal(value = TemporalType.DATE)
    @Column(name = "createDate")
    private Date createDate = new Date();

    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "updateDate")
    private Date updateDate = new Date();

    public BaseDomain() {

    }

    public BaseDomain(Long id, boolean isActive, Date createDate, Date updateDate) {
        this.id = id;
        this.isActive = isActive;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

}
