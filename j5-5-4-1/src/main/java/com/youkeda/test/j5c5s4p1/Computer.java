package com.youkeda.test.j5c5s4p1;

public class Computer {
    private int count = 30;

    private Computer(){

    }

    private static Computer computer = new Computer();

    public static Computer getComputer(){
        return computer;
    }

    public int getCount(){
        return count;
    }

    public synchronized  void sell(){
        if(count > 0){
            count--;
            System.out.println(Thread.currentThread().getName()+"买走一台，剩余库存为"+count+"台");
        }else{
            System.out.println(Thread.currentThread().getName()+"秒杀失败，库存为0");
        }
    }
}
