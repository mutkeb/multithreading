package com.youkeda.test.j5c4s4p1;

public class AbstractTruck implements Truck{
    private String function;

    @Override
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
