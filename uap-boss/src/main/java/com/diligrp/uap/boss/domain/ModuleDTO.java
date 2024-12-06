package com.diligrp.uap.boss.domain;

/**
 * 用于模块新增和修改的数据模型
 */
public class ModuleDTO {
    // 模块ID
    private Long id;
    // 模块编码
    private String code;
    // 模块名称
    private String name;
    // 模块类型
    private Integer type;
    // 绝对路径
    private String uri;
    // 模块图标
    private String icon;
    // 备注
    private String description;
    // 顺序号
    private Integer sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}