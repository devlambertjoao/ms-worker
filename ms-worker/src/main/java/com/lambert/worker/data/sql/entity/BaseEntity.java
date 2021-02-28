package com.lambert.worker.data.sql.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity {
    @SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

    private Date createdAt;
    private Date updatedAt;

    @PreUpdate
    public void preUpdate(){
    	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
		TimeZone.setDefault(tz);    	
        this.setUpdatedAt(Calendar.getInstance(tz).getTime());
    }
    
    @PrePersist
    public void prePersist(){
        if(this.getCreatedAt() == null){
        	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
    		TimeZone.setDefault(tz); 
            this.setCreatedAt(Calendar.getInstance(tz).getTime());
        }
    }
    
    @Column(name = "createdAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedAt() {
     	return this.createdAt; 
    }

    public void setCreatedAt(Date includeDate) {
        this.createdAt = includeDate;
    }

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedAt() {
         return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
