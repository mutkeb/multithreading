package com.youkeda;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        PrintStream out = System.out;

        boolean checkResult = checkClass(out);
        if (!checkResult) {
            return;
        }

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.j5c4s3p2.Stduent");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c4s3p2.Stduent`类");
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
                error("`com.youkeda.test.j5c4s3p2.Stduent`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c4s3p2.Stduent`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);
        String[] strings = result.split("\n");

        String numStr = strings[strings.length - 1];
        if (!"牛肉".equals(numStr)) {
          error("最后一行应该输出“牛肉”");
        }

        String numStr2 = strings[strings.length - 2];
        if (!"番茄炒蛋".equals(numStr2)) {
          error("倒数第二行应该输出“番茄炒蛋”");
        }
    }

    private boolean checkClass(PrintStream out) {
        boolean result = true;
        try {
            Class<?> afClass = Class.forName("com.youkeda.test.j5c4s3p2.AbstractFood");

            Method method = afClass.getDeclaredMethod("setName", String.class);
            Method method2 = afClass.getDeclaredMethod("getName");
            Field field = afClass.getDeclaredField("name");
        } catch (ClassNotFoundException e) {
            System.setOut(out);
            error("没有创建`com.youkeda.test.j5c4s3p2.AbstractFood`类");
            result = false;
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c4s3p2.AbstractFood`类没有创建`setName(String)`方法和`getName()`方法");
            result = false;
        } catch (NoSuchFieldException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c4s3p2.AbstractFood`类没有创建`name`属性");
            result = false;
        }

        return result;
    }

}
