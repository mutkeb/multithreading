package com.youkeda.test.j5c4s4p1;

public class FourServiceShop {
    public static void main(String[] args) {
        VehicleFactoryProducer vfp = new VehicleFactoryProducer();
        VehicleFactory carFactory = vfp.getFactory("car");
        Car fukang = carFactory.makeCar("fukang");
        System.out.println(fukang.getBrand());
        Car elysee = carFactory.makeCar("elysee");
        System.out.println(elysee.getBrand());
        //  货车
        VehicleFactory truckFactory = vfp.getFactory("truck");
        Truck offRoadTruck = truckFactory.makeTruck("off-road");
        System.out.println(offRoadTruck.getFunction());
        Truck CargoTruck = truckFactory.makeTruck("cargo");
        System.out.println(CargoTruck.getFunction());
    }
}
