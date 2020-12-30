package com.example.verynb.ui.shop;

import java.util.ArrayList;

public class QingBean {
    private String naem;
    private ArrayList<String> list;

    @Override
    public String toString() {
        return "QingBean{" +
                "naem='" + naem + '\'' +
                ", list=" + list +
                '}';
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
