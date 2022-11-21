package com.youkeda.test.j5c5s7p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class OfferTest {
    public static void main(String[] args) {
        List<Offer> offers = getOffers();

        Publisher pub = new Publisher();
        offers.stream()
                .forEach(offer -> {
                    CompletableFuture.supplyAsync(() -> pub.save(offer))
                    .thenApply(offer1 -> {
                        return pub.examine(offer1);
                    })
                    .thenAccept(offer1 -> {
                        pub.publish(offer1);
                    });
                });

    }

    // 获取一批商品数据
    private static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();

        for (int i = 1; i <= 3000; i++) {
            Offer offer = new Offer();
            offer.setTitle("Nike 黑白宇航员泡椒3代战靴" + i);

            offer.setImages(Arrays.asList(
                "https://gw.alicdn.com/tfscom/https://img.alicdn.com/imgextra/i4/2689779491/O1CN01eCUUdR2JyvbHi2lKz_!!2689779491-0-daren.jpg"));

            offers.add(offer);
        }

        return offers;
    }
}
