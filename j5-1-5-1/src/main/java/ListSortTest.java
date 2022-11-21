import java.util.*;

public class ListSortTest {
    public static void main(String[] args) {
      List<Student> ar = new ArrayList<Student>();
      ar.add(new Student(111, "孟子", "London", 20));
      ar.add(new Student(131, "陈寿", "NYC", 18));
      ar.add(new Student(121, "王维", "Jaipur", 19));
      ar.add(new Student(171, "亚里士多德", "Greek", 24));
      ar.add(new Student(141, "达芬奇", "Italy", 22));
      ar.add(new Student(151, "梅林", "London", 17));

      print(ar);
    }

    public static void print(List<Student> ar) {
        System.out.println("原始集合");
        ar.forEach(System.out::println);

        Collections.sort(ar,ListSortTest::compare);

        System.out.println("\n排序后的集合");
        ar.forEach(System.out::println);
    }

    public static int compare(Student a, Student b) {
        System.out.println("比较年龄：a.age=" + a.getAge() + ",b.age=" + b.getAge());
        return b.getAge() - a.getAge();
    }
}