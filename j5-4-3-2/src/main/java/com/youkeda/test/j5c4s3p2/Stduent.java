package com.youkeda.test.j5c4s3p2;

public class Stduent {
    public static void main(String[] args) {
        Food food = Canteen.foodFactory("rice");
        System.out.println(food.getName());
        Food food1 = Canteen.foodFactory("beef");
        System.out.println(food1.getName());
        Food food2 = Canteen.foodFactory("tomato");
        System.out.println(food2.getName());
    }
}
