package com.compoent.entity;

import javax.persistence.*;

@Table(name = "component")
public class ComponeCnt {
    @Id
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String introduce;

    /**
     * 类别
     */
    private String classify;

    /**
     * 数量
     */
    private Integer numbers;

    private String extr1;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取描述
     *
     * @return introduce - 描述
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 设置描述
     *
     * @param introduce 描述
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * 获取类别
     *
     * @return classify - 类别
     */
    public String getClassify() {
        return classify;
    }

    /**
     * 设置类别
     *
     * @param classify 类别
     */
    public void setClassify(String classify) {
        this.classify = classify;
    }

    /**
     * 获取数量
     *
     * @return numbers - 数量
     */
    public Integer getNumbers() {
        return numbers;
    }

    /**
     * 设置数量
     *
     * @param numbers 数量
     */
    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    /**
     * @return extr1
     */
    public String getExtr1() {
        return extr1;
    }

    /**
     * @param extr1
     */
    public void setExtr1(String extr1) {
        this.extr1 = extr1;
    }
}