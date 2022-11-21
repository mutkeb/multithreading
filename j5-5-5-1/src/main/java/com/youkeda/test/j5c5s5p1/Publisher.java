package com.youkeda.test.j5c5s5p1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商品发布器
 */
public class Publisher implements Runnable{
    private static AtomicInteger count = new AtomicInteger(1000);
    private Offer offer;
    public Publisher(Offer offer) {
        this.offer = offer;
    }

    @Override
    public void run() {
        offer.setId(count.incrementAndGet());
        publish();
    }
    public void publish() {
        System.out.println("商品标题：" + offer.getTitle() + "，商品ID：" + offer.getId());
    }
}