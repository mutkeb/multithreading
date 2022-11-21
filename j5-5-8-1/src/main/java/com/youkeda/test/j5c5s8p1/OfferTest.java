package com.youkeda.test.j5c5s8p1;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class OfferTest {

    //  线程工厂
    private static final ThreadFactory namedThreadFactory =  new BasicThreadFactory.Builder()
            .namingPattern("offer-pool-%d")
            .daemon(true)
            .build();

    //  等待队列
    private static  final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(1024);

    //  线程池服务
    private static final ThreadPoolExecutor EXECUTOR_SERVICE = new ThreadPoolExecutor(
            20,
            200,
            30,
            TimeUnit.SECONDS,
            workQueue,
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy()
    );
    public static void main(String[] args) {
        List<Offer> offers = getOffers();
        offers.stream()
                .forEach(offer -> {
                    Publisher p = new Publisher(offer);
                    //  传入Runnable对象，运行任务
                    EXECUTOR_SERVICE.execute(p);
                });
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 获取一批商品数据
    // 获取一批商品数据
    private static List<Offer> getOffers() {
        List<Offer> offers = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            Offer offer = new Offer();
            offer.setTitle("Nike 黑白宇航员泡椒3代战靴" + i);

            offer.setImages(Arrays.asList(
                "https://gw.alicdn.com/tfscom/https://img.alicdn.com/imgextra/i4/2689779491/O1CN01eCUUdR2JyvbHi2lKz_!!2689779491-0-daren.jpg"));

            offers.add(offer);
        }

        return offers;
    }
}
