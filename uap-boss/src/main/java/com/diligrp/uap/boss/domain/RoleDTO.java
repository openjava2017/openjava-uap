package com.diligrp.uap.boss.domain;

import java.time.LocalDateTime;

public class RoleDTO {
    // 角色ID
    private Long id;
    // 角色名称
    private String name;
    // 角色描述
    private String description;
    // 创建时间
    private LocalDateTime createdTime;
    // 修改时间
    private LocalDateTime modifiedTime;

    public static RoleDTO of(Long id, String name, String description,
                             LocalDateTime createdTime, LocalDateTime modifiedTime) {
        RoleDTO role = new RoleDTO();
        role.setId(id);
        role.setName(name);
        role.setDescription(description);
        role.setCreatedTime(createdTime);
        role.setModifiedTime(modifiedTime);
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}