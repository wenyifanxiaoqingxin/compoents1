package com.compoent.compoent.entity;

public class Person {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.hashCode() == Integer.parseInt(this.id)){
            return  true;
        }else{
            return false;
        }
    }
}
