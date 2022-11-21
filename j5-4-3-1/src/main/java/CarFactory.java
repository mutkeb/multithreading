public class CarFactory {
    public static Car makeCar(String brand){
        Car car = null;
        if(brand.equals("fukang")){
            car = new FuKang();
        }else if(brand.equals("elyee")){
            car = new Elysee();
        }
        return car;
    }
}
