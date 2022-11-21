package com.youkeda.test.j5c5s2p1;

import java.util.Random;

public class TakeNumber extends Thread{
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run(){
        Random random = new Random();
        number = random.nextInt() * 9 + 1;
    }

}
