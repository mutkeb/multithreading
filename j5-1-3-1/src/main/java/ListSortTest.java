import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(111, "孟子", "London", 20));
        students.add(new Student(131, "陈寿", "NYC", 18));
        students.add(new Student(121, "王维", "Jaipur", 19));
        students.add(new Student(171, "亚里士多德", "Greek", 24));
        students.add(new Student(141, "达芬奇", "Italy", 22));
        System.out.println("原始集合");
        students.forEach(f->{
            System.out.println(f);
        });

        System.out.println("\n排序后的集合");
        Collections.sort(students, (Student student1,Student student2)->{
            return student1.getAge() - student2.getAge();
        });
        students.forEach(f ->{
            System.out.println(f);
        });
    }
}