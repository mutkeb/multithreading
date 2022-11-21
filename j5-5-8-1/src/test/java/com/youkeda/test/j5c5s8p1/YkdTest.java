package com.youkeda.test.j5c5s8p1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        PrintStream out = System.out;

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.j5c5s8p1.OfferTest");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c5s8p1.OfferTest`类");
            return;
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Method method = aClass.getMethod("main", String[].class);
            try {
                method.invoke(null, (Object)new String[] {});
            } catch (Exception e) {
                System.setOut(out);
                error("`com.youkeda.test.j5c5s8p1.OfferTest`类 main 执行错误:" + e.getMessage());
                return;
            }

            TimeUnit.SECONDS.sleep(6);
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s8p1.OfferTest`类没有创建 main 方法");
            return;
        } catch (InterruptedException ne) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s8p1.OfferTest`类执行异常." + ne.getMessage());
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        if (result == null || !result.contains("黑白宇航员泡椒3代战靴") || !result.contains("1000")) {
            error("输出内容错误，请检查格式，必须包含商品名称及 ID");
        }
    }
}
