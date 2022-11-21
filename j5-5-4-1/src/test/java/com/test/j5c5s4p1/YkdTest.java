package com.youkeda.test.j5c5s4p1;

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
            aClass = Class.forName("com.youkeda.test.j5c5s4p1.SeckillTest");
        } catch (ClassNotFoundException e) {
            error("没有创建`com.youkeda.test.j5c5s4p1.SeckillTest`类");
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
                error("`com.youkeda.test.j5c5s4p1.SeckillTest`类 main 执行错误:" + e.getMessage());
                return;
            }

            TimeUnit.SECONDS.sleep(6);
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s4p1.SeckillTest`类没有创建 main 方法");
            return;
        } catch (InterruptedException ne) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s4p1.SeckillTest`类执行异常." + ne.getMessage());
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        if (result == null || !result.contains("库存 29 台") || !result.contains("库存为 0")) {
            error("输出内容错误，请检查格式，特别是空格");
        }
    }

    private boolean checkClass(PrintStream out) {
        boolean result = true;
        try {
            Class<?> afClass = Class.forName("com.youkeda.test.j5c5s4p1.Computer");

            Method method2 = afClass.getDeclaredMethod("getInstance");

            Field field = afClass.getDeclaredField("count");

            Class<?> customerClass = Class.forName("com.youkeda.test.j5c5s4p1.Customer");

            Class parentClass = customerClass.getSuperclass();
            if (parentClass.getName().equals("java.lang.Thread")) {
                error("`com.youkeda.test.j5c5s4p1.TakeNumber`不能继承自`Thread`类");
            }

            boolean implRun = false;
            Class<?>[] inters = customerClass.getInterfaces();
            for (Class inter : inters) {
                if (inter.getName().equals("java.lang.Runnable")) {
                    implRun = true;
                    break;
                }
            }

            if (!implRun) {
                error("`com.youkeda.test.j5c5s4p1.Customer`必须实现`Runnable`接口");
            }

        } catch (ClassNotFoundException e) {
            System.setOut(out);
            error("没有创建`com.youkeda.test.j5c5s4p1.Computer`类");
            result = false;
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s4p1.Computer`类没有创建`getInstance()`方法");
            result = false;
        } catch (NoSuchFieldException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c5s4p1.Computer`类没有创建`count`属性");
            result = false;
        }

        return result;
    }
}
