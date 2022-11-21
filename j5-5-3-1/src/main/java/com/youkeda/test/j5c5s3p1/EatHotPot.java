package com.youkeda.test.j5c5s3p1;

import java.util.Random;

public class EatHotPot {
    public static void main(String[] args) {
        //  林妙妙线程创建
        TakeNumber thread1 = new TakeNumber();
        thread1.setName("林妙妙");
        Thread threadOne = new Thread(thread1);

        //  钱三一线程创建
        TakeNumber thread2 = new TakeNumber();
        thread2.setName("钱三一");
        Thread threadTwo = new Thread(thread2);
        //  开始进程
        threadOne.start();
        threadTwo.start();


    }
}
