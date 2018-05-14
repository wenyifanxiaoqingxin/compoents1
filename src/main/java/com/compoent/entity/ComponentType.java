package com.compoent.entity;

import javax.persistence.*;

@Table(name = "compoent_type")
public class ComponentType {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 分类名称
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 父节点id
     */
    @Column(name = "type_parent_id")
    private String typeParentId;

    /**
     * 预留字段1
     */
    private String extr1;

    /**
     * 预留字段2
     */
    private String extr2;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return type_name - 分类名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置分类名称
     *
     * @param typeName 分类名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取父节点id
     *
     * @return type_parent_id - 父节点id
     */
    public String getTypeParentId() {
        return typeParentId;
    }

    /**
     * 设置父节点id
     *
     * @param typeParentId 父节点id
     */
    public void setTypeParentId(String typeParentId) {
        this.typeParentId = typeParentId;
    }

    /**
     * 获取预留字段1
     *
     * @return extr1 - 预留字段1
     */
    public String getExtr1() {
        return extr1;
    }

    /**
     * 设置预留字段1
     *
     * @param extr1 预留字段1
     */
    public void setExtr1(String extr1) {
        this.extr1 = extr1;
    }

    /**
     * 获取预留字段2
     *
     * @return extr2 - 预留字段2
     */
    public String getExtr2() {
        return extr2;
    }

    /**
     * 设置预留字段2
     *
     * @param extr2 预留字段2
     */
    public void setExtr2(String extr2) {
        this.extr2 = extr2;
    }
}