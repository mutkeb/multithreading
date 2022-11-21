package com.youkeda.test.j5c5s7p1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商品发布器
 */
public class Publisher {
    private static AtomicInteger count = new AtomicInteger(1000);

    public Offer save(Offer offer) {
        offer.setId(count.incrementAndGet());

        return offer;
    }

    public Offer examine(Offer offer) {
        System.out.println("商品审核成功。标题：" + offer.getTitle() + "，ID：" + offer.getId());
        return offer;
    }

    public void publish(Offer offer) {
        System.out.println("商品发布成功。标题：" + offer.getTitle() + "，ID：" + offer.getId());
    }
}