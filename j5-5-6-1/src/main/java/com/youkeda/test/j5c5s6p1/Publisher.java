package com.youkeda.test.j5c5s6p1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 商品发布器
 */
public class Publisher {
    private static AtomicInteger count = new AtomicInteger(1000);

    //  发布商品
    public void publish(Offer offer){
        System.out.println("商品发布成功。标题："+offer.getTitle()+"，商品ID："+offer.getId());
    }

    public Offer save(Offer offer){
        offer.setId(count.incrementAndGet());
        return offer;
    }
}