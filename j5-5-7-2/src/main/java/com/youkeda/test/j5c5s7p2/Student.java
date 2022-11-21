package com.youkeda.test.j5c5s7p2;

/**
 * 学生
 */
public class Student {
    // 姓名
    private String name;
    // 座位号。初始化为 -1 表示没有座位
    private int placeIndex = -1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaceIndex() {
        return placeIndex;
    }

    public void setPlaceIndex(int placeIndex) {
        this.placeIndex = placeIndex;
    }
}
