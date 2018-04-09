package com.tw;

import java.util.HashMap;

/**
 * Created by wanglei on 2018/4/9.
 */
public class Info {
    private String name;
    private int num;
    private HashMap classes;

    public HashMap getClasses() {
        return classes;
    }

    public void setClasses(HashMap classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
