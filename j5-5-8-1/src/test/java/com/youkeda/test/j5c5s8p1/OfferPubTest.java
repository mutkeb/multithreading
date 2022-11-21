package com.youkeda.test.j5c5s8p1;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class OfferPubTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.j5c5s8p1.OfferTest");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c5s8p1.OfferTest`类");
            return;
        }

        try {
            Method method = aClass.getMethod("main", String[].class);
            try {
                method.invoke(null, (Object)new String[] {});
                Thread.sleep(7000);
            } catch (Exception e) {
                error("`com.youkeda.test.j5c5s8p1.OfferTest`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            error("`com.youkeda.test.j5c5s8p1.OfferTest`类没有创建 main 方法");
            return;
        }
    }
}
