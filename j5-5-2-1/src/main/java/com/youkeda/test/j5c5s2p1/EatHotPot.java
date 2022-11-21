package com.youkeda.test.j5c5s2p1;

public class EatHotPot {
    public static void main(String[] args) {
        //  林妙妙线程
        TakeNumber thread1 = new TakeNumber();
        thread1.setName("林妙妙");
        //  钱三一线程
        TakeNumber thread2 = new TakeNumber();
        thread2.setName("钱三一");

        //  启动线程
        thread1.start();
        thread2.start();

        System.out.println(thread1.getName()+" 拿到的排队号码是："+ thread1.getNumber());
        System.out.println(thread2.getName()+" 拿到的排队号码是："+ thread2.getNumber());

    }
}
