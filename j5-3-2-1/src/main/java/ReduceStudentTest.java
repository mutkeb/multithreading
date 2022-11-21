import java.util.ArrayList;
import java.util.List;

public class ReduceStudentTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("赵祯", 92, 92));
        students.add(new Student("曹丹姝", 60, 75));
        students.add(new Student("赵徽柔", 80, 95));
        students.add(new Student("韩琦", 100, 83));
        students.add(new Student("梁怀吉", 64, 100));
        students.add(new Student("张茂则", 66, 62));
        students.add(new Student("晏殊", 76, 61));
        students.add(new Student("张妼晗", 62,78));
        students.add(new Student("夏竦", 79, 65));
        students.add(new Student("范仲淹", 98, 83));

        Student student = students.stream()
                .reduce(new Student("", 0, 0),
                        (a, b) -> {
                            a.setMidtermScore(a.getMidtermScore() + b.getMidtermScore());
                            a.setLastScore(a.getLastScore() + b.getLastScore());
                            return a;
                        });
        System.out.println("三年二班期中考试平均分："+ student.getMidtermScore());
        System.out.println("三年二班期末考试平均分:" + student.getLastScore());

    }
}
