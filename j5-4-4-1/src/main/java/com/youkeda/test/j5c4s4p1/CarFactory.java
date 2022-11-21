package com.youkeda.test.j5c4s4p1;

public class CarFactory implements VehicleFactory{
    @Override
    public Car makeCar(String brand) {
        Car car = null;
        if ("fukang".equals(brand)) {
            FuKang fukang = new FuKang();
            fukang.setBrand("富康");
            car = fukang;
        } else if ("elysee".equals(brand)) {
            Elysee elysee = new Elysee();
            elysee.setBrand("爱丽舍");
            car = elysee;
        }

        return car;
    }

    @Override
    public Truck makeTruck(String func) {
        return null;
    }

}
