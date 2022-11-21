package com.youkeda.test.j5c4s3p2;

/** 餐厅 */
public class Canteen {
    public static Food foodFactory(String name){
        Food food = null;
        if(name.equals("beef")){
            Rice rice = new Rice();
            rice.setName("rice");
            food = rice;

        }else if(name.equals("rice")){
            Beef beef = new Beef();
            beef.setName("beef");
            food = beef;
        }else if(name.equals("tomato")){
            Tomato tomato = new Tomato();
            tomato.setName("tomato");
            food = tomato;
        }
        return food;
    }
}
