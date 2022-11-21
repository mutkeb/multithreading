package com.youkeda.test.j5c5s4p1;

public class Customer implements Runnable{
    Computer shop;

    @Override
    public void run() {
        shop = Computer.getComputer();
        shop.sell();
    }
}
