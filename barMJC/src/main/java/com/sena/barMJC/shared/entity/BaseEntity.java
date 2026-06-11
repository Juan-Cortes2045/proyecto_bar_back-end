package com.sena.barMJC.shared.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import  java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name="status", nullable= false)
    protected Boolean status;

    @Column(name="created_at", updatable= false, nullable= false)
    protected LocalDateTime createdAt;

    @Column(name="updated_at", nullable= false)
    protected LocalDateTime updatedAt;


    @PrePersist
    protected  void onCreate(){
        this.createdAt= LocalDateTime.now();
        this.updatedAt= LocalDateTime.now();
        this.status= true;
    }

    @PreUpdate
    protected  void onUpdate(){
        this.updatedAt= LocalDateTime.now();
    }

}
