package com.youkeda.test.j5c4s4p1;

public class VehicleFactoryProducer {
    public VehicleFactory getFactory(String choice){
        if(choice.equals("car")){
            return new CarFactory();
        }else if (choice.equals("truck")){
            return new TruckFactory();
        }
        return null;
    }
}
