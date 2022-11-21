package com.youkeda.test.j5c5s4p1;

public class SeckillTest {
    public static void main(String[] args) {
        for (int i = 0 ; i < 200 ; i++){
            Customer customer = new Customer();
            Thread thread = new Thread(customer);
            thread.setName("顾客"+(i+1));
            thread.start();
        }
    }
}
