package com.youkeda.test.j5c4s4p1;

public class TruckFactory implements VehicleFactory{
    @Override
    public Car makeCar(String brand) {
        return null;
    }

    @Override
    public  Truck makeTruck(String function){
        Truck truck = null;
        if(function.equals("off-road")){
            OffRoadTruck offRoadTruck = new OffRoadTruck();
            offRoadTruck.setFunction("off-road");
            truck = offRoadTruck;
        }else if(function.equals("cargo")){
            CargoTruck cargoTruck = new CargoTruck();
            cargoTruck.setFunction("cargo");
            truck = cargoTruck;
        }
        return truck;
    }
}
