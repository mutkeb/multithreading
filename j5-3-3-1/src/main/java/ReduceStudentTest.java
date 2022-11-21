import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


        List<Student> collect = students.stream()
                .sorted((student1, student2) -> {
                    return student2.getMidtermScore() + student2.getLastScore() - student1.getLastScore() - student1.getMidtermScore();
                })
                .limit(5)
                .collect(Collectors.toList());

        collect.forEach(c->{
            System.out.println(c.getName()+"-"+c.getMidtermScore()+"-"+c.getLastScore());
        });
    }
}
