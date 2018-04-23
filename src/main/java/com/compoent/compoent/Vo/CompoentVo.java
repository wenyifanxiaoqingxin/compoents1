package com.compoent.compoent.Vo;

/**
 * Created by fx on 2018/1/2.
 */
public class CompoentVo {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;


    private  String pageNumber;

    private String pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
