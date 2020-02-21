package com.rrdev.navigationdrawer.model;

public class DataModel {
    private int img;
    private String name;
    private String descripstion;

    public DataModel(int img, String name, String descripstion) {
        this.img = img;
        this.name = name;
        this.descripstion = descripstion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripstion() {
        return descripstion;
    }

    public void setDescripstion(String descripstion) {
        this.descripstion = descripstion;
    }
}
