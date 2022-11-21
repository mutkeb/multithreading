import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(111,"张三","london",20));
        students.add(new Student(131,"李四","nyc",18));
        students.add(new Student(121,"王五","jaipur",19));

        Collections.sort(students,(student1,student2)->{
            return student1.getAge() - student2.getAge();
        });

        students.forEach(f->{
            System.out.println(f);
        });
    }

}