package com.youkeda.test.j5c4s4p2;

public abstract class AbstractDrink implements Drink{
    private String name;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
