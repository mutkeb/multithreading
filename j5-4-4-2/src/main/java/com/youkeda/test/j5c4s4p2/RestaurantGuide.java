package com.youkeda.test.j5c4s4p2;

public class RestaurantGuide {
    public DiningArea guideEat(String choice) {
        if(choice.equals("food")){
            return new Canteen();
        }else if (choice.equals("drink")){
            return new VendingMachine();
        }
        return null;
    }
}
