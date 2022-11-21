package com.youkeda;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        PrintStream out = System.out;

        Class<?> aClass = null;
        try {
            aClass = Class.forName("CarShop");
        } catch (ClassNotFoundException e) {
            error("没有创建`CarShop`类");
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
                error("`CarShop`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`CarShop`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);
        String[] strings = result.split("\n");

        String numStr = strings[strings.length - 1];
        if (!"爱丽舍".equals(numStr)) {
          error("最后一行应该输出“爱丽舍”");
        }

        String numStr2 = strings[strings.length - 2];
        if (!"富康".equals(numStr2)) {
          error("倒数第二行应该输出“富康”");
        }

    }

}
