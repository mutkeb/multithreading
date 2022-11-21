package com.youkeda.test.j5c4s2p2;

public class LaserPrinter {
    private LaserPrinter(){

    }

    private static LaserPrinter laserPrinter = new LaserPrinter();

    public static LaserPrinter getInstance(){
        return laserPrinter;
    }

    public void print(String content){
        System.out.println(content);
    }
}
