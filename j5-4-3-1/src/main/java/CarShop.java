public class CarShop {
    public static void main(String[] args) {
        Car fukang = CarFactory.makeCar("fukang");
        System.out.println(fukang.getBrand());

        Car elysee = CarFactory.makeCar("elysee");
        System.out.println(elysee.getBrand());
    }
}
