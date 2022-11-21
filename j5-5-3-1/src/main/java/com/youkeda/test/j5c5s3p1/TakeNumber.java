package com.youkeda.test.j5c5s3p1;

import java.util.Random;

public class TakeNumber implements Runnable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        Random random = new Random();
        System.out.println(name+" 拿到的排队号码是:"+ random.nextInt(10));
    }
}
