package com.youkeda;

import com.youkeda.test.j5c4s2p2.LaserPrinter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class YkdTest2 {

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

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        LaserPrinter lp = LaserPrinter.getInstance();
        lp.print("apple");

        String result = baos.toString();
        System.setOut(out);
        String[] strings = result.split("\n");

        String numStr = strings[strings.length - 1];
        if (!"apple".equals(numStr)) {
            error("最后一行应该输出“apple”");
        }
    }

    private boolean checkClass(PrintStream out) {
        boolean result = true;
        try {
            Class<?> afClass = Class.forName("com.youkeda.test.j5c4s2p2.LaserPrinter");

            Method method = afClass.getDeclaredMethod("print", String.class);
            Method method2 = afClass.getDeclaredMethod("getInstance");

            Field[] fields = afClass.getDeclaredFields();

            boolean privateFile = false;
            for (Field field : fields) {
                Class<?> typC = field.getType();
                if (typC.getName().equals("com.youkeda.test.j5c4s2p2.LaserPrinter")) {
                    privateFile = true;
                }
            }

            result = privateFile;
        } catch (ClassNotFoundException e) {
            System.setOut(out);
            error("没有创建`com.youkeda.test.j5c4s2p2.LaserPrinter`类");
            result = false;
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`com.youkeda.test.j5c4s2p2.LaserPrinter`类没有创建`print(String)`方法和`getInstance()`方法");
            result = false;
        }

        return result;
    }
}
