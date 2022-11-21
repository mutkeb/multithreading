import java.util.*;

public class ListSortTest {

    private static Student a = new Student(151, "梅林", "London", 17);
    public static void main(String[] args) {
        List<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "孟子", "London", 20));
        ar.add(new Student(131, "陈寿", "NYC", 18));
        ar.add(new Student(121, "王维", "Jaipur", 19));
        ar.add(new Student(171, "亚里士多德", "Greek", 24));
        ar.add(new Student(141, "达芬奇", "Italy", 22));
        ar.add(a);

        String message = "比较年龄:";

        System.out.println("原始集合");
        ar.forEach(s -> System.out.println(s));

        Collections.sort(ar, (a, b) -> {
            System.out.println(message);
            return b.getAge() - a.getAge();
        });

        String newmessage = "排序后的集合";
        System.out.println("\n" + newmessage);
        ar.forEach(s -> System.out.println(s));
    }
}