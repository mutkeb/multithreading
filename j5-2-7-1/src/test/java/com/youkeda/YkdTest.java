package com.youkeda;

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
        Class<?> aClass = null;
        try {
            aClass = Class.forName("PupilTest3");
        } catch (ClassNotFoundException e) {
            error("没有创建`PupilTest3`类");
            return;
        }

        PrintStream out = System.out;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        try {
            Method method = aClass.getMethod("main", String[].class);
            try {
                method.invoke(null, (Object)new String[] {});
            } catch (Exception e) {
                System.setOut(out);
                error("`PupilTest3`类 main 执行错误:" + e.getMessage());
                return;
            }
        } catch (NoSuchMethodException e) {
            System.setOut(out);
            error("`PupilTest3`类没有创建 main 方法");
            return;
        }

        String result = baos.toString();
        System.setOut(out);

        String[] strings = result.split("\n");
        int i = 1;
        while (i < 2) {
            int index = strings.length - i;
            String numStr = strings[index];
            if (!numStr.contains("夜华") || !numStr.contains("成绩优秀")) {
              error("最后一行应该输出“白浅同学您的成绩优良，恭喜入围”");
            }
            i++;
        }

    }

}
