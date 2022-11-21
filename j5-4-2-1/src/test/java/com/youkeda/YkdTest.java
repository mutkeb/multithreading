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
        checkClass(out);

        Class<?> aClass = null;
        try {
            aClass = Class.forName("BankTest");
        } catch (ClassNotFoundException e) {
            error("没有创建`BankTest`类");
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
                error("`BankTest`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`BankTest`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);
        String[] strings = result.split("\n");

        String numStr = strings[strings.length - 1];
        if (!"楼山关取出420元，余额6280元".equals(numStr)) {
          error("最后一行应该输出“楼山关取出420元，余额6280元”");
        }

        String numStr2 = strings[strings.length - 2];
        if (!"徐文昌取出1000元，余额8200元".equals(numStr2)) {
          error("倒数第二行应该输出“徐文昌取出1000元，余额8200元”");
        }

    }

    private void checkClass(PrintStream out) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName("Bank");
            Constructor[] cons = aClass.getDeclaredConstructors();
            for (Constructor constructor : cons) {
                String modifier = Modifier.toString(constructor.getModifiers());
                if (!"private".equals(modifier)) {
                    System.setOut(out);
                    error("`Bank`类的构造方法必须是 private");
                    return;
                }
            }
        } catch (ClassNotFoundException e) {
            error("没有创建`Bank`类");
            return;
        }
    }

}
