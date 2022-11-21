import java.util.ArrayList;
import java.util.List;

public class ReduceStudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("赵祯", 92));
        students.add(new Student("曹丹姝", 60));
        students.add(new Student("赵徽柔", 80));
        students.add(new Student("韩琦", 100));
        students.add(new Student("梁怀吉", 64));
        students.add(new Student("张茂则", 66));
        students.add(new Student("晏殊", 76));
        students.add(new Student("张妼晗", 62));
        students.add(new Student("夏竦", 79));
        students.add(new Student("范仲淹", 98));

        int sum = students.stream()
                .map(student -> {
                    return student.getMidtermScore();
                })
                .reduce((a, b) -> a + b)
                .get();
        System.out.println("三年二班期中考试平均分：" + sum / 10 );
    }
}
