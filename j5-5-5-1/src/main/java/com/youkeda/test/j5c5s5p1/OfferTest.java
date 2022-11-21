package com.youkeda.test.j5c5s5p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferTest {
    public static void main(String[] args) {
        List<Offer> offers = getOffers();

        offers.forEach(offer -> {
                    Publisher publisher = new Publisher(offer);
                    Thread thread = new Thread(publisher);
                    thread.start();
                });
    }

    // 获取一批商品数据
    private static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();

        Offer offer1 = new Offer();
        offer1.setTitle("Nike 黑白宇航员泡椒3代战靴");
        offer1.setImages(Arrays.asList(
            "https://gw.alicdn.com/tfscom/https://img.alicdn.com/imgextra/i4/2689779491/O1CN01eCUUdR2JyvbHi2lKz_!!2689779491-0-daren.jpg"));
        offers.add(offer1);

        Offer offer2 = new Offer();
        offer2.setTitle("Karrimor 重型户外载重包架");
        offer2.setImages(Arrays.asList(
            "https://gw.alicdn.com/tfscom/https://img.alicdn.com/imgextra/i1/2925577988/O1CN0128sYF7Clch08w3v_!!2925577988-0-daren.jpg"));
        offers.add(offer2);

        Offer offer3 = new Offer();
        offer3.setTitle("Nike Air Max彩色气垫跑鞋");
        offer3.setImages(Arrays.asList(
            "https://gw.alicdn.com/tfscom/https://img.alicdn.com/imgextra/i4/2913435316/O1CN01sLCKT81p8m0ALR3oq_!!2913435316-0-daren.jpg"));
        offers.add(offer3);

        Offer offer4 = new Offer();
        offer4.setTitle("kappa 复古串标夹克外套");
        offer4.setImages(Arrays.asList(
            "https://gw.alicdn.com/tfscom/img.alicdn.com/imgextra/i1/675114980/O1CN011messEKH0dCuDYK_!!675114980-0-daren.jpg"));
        offers.add(offer4);

        return offers;
    }
}
