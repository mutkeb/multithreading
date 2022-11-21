package com.youkeda.test.j5c5s7p2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        PrintStream out = System.out;

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.j5c5s7p2.NightStudy");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c5s7p2.NightStudy`类");
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
                error("`com.youkeda.test.j5c5s7p2.NightStudy`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s7p2.NightStudy`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        if (result == null || !result.contains("同学20号学习结束离开座位") || !result.contains("座位号：2")) {
            error("输出内容错误，请检查格式，必须输出【同学20号学习结束离开座位】，以及必须输出【座位号：2】。输出内容为：" + result);
        }
    }
}
