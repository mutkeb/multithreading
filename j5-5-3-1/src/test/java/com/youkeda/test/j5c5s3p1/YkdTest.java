package com.youkeda.test.j5c5s3p1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class YkdTest {

    public static void error(String msg) {
        System.err.println("<YkdError>" + msg + "</YkdError>");
    }

    @Test
    public void runB() {
        PrintStream out = System.out;

        boolean check = checkClass(out);
        if (!check) {
            return;
        }

        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.youkeda.test.j5c5s3p1.EatHotPot");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c5s3p1.EatHotPot`类");
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
                error("`com.youkeda.test.j5c5s3p1.EatHotPot`类 main 执行错误:" + e.getMessage());
                return;
            }

            TimeUnit.SECONDS.sleep(5L);
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s3p1.EatHotPot`类没有创建 main 方法");
            return;
        } catch (InterruptedException ne) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s3p1.EatHotPot`类执行异常." + ne.getMessage());
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        if (result == null || !result.contains("钱三一") || !result.contains("林妙妙")) {
            error("输出内容必须包含姓名");
        }
    }

    private boolean checkClass(PrintStream out) {
        boolean result = true;
        try {
            Class<?> afClass = Class.forName("com.youkeda.test.j5c5s3p1.TakeNumber");

            Method method2 = afClass.getDeclaredMethod("run");

            Field field = afClass.getDeclaredField("number");
            Field field2 = afClass.getDeclaredField("name");

            Class parentClass = afClass.getSuperclass();
            if (parentClass.getName().equals("java.lang.Thread")) {
                error("`com.youkeda.test.j5c5s3p1.TakeNumber`不能继承自`Thread`类");
            }

            boolean implRun = false;
            Class<?>[] inters = afClass.getInterfaces();
            for (Class inter : inters) {
                if (inter.getName().equals("java.lang.Runnable")) {
                    implRun = true;
                    break;
                }
            }

            if (!implRun) {
                error("`com.youkeda.test.j5c5s3p1.TakeNumber`必须实现`Runnable`接口");
            }

        } catch (ClassNotFoundException e) {
            System.setOut(out);
            error("没有创建`com.youkeda.test.j5c5s3p1.TakeNumber`类");
            result = false;
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s3p1.TakeNumber`类没有创建`run()`方法");
            result = false;
        } catch (NoSuchFieldException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s3p1.TakeNumber`类没有创建`number`属性");
            result = false;
        }

        return result;
    }
}
