package com.youkeda.test.j5c4s4p1;

public abstract class AbstractCar implements Car{
    private String brand;

    @Override
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
