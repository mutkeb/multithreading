import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ParallelStreamTest {
    public static void main(String[] args) {
        testStream();
        testParallelStream();
    }

    public static void testStream() {
        // 起始时间
        LocalTime start = LocalTime.now();

        List<Student> list = buildData();

        List<Student> newDatas = list.stream()
                .sorted((student1,student2)->{
                    return student2.getLastScore() + student2.getMidtermScore() - student1.getMidtermScore() - student1.getLastScore();
                })
                .limit(1000)
                .collect(Collectors.toList());
        // 终止时间
        LocalTime end = LocalTime.now();

        // 时间间隔
        Duration duration = Duration.between(start, end);
        // 输出时间间隔毫秒值
        System.out.println("串行流耗时：" + duration.toMillis());
    }

    private static void testParallelStream() {
        // 起始时间
        LocalTime start = LocalTime.now();

        List<Student> list = buildData();

        List<Student> newDatas = list.parallelStream()
                .sorted((student1,student2)->{
                    return student2.getLastScore() + student2.getMidtermScore() - student1.getMidtermScore() - student1.getLastScore();
                })
                .limit(1000)
                .collect(Collectors.toList());

        // 终止时间
        LocalTime end = LocalTime.now();

        // 时间间隔
        Duration duration = Duration.between(start, end);
        // 输出时间间隔毫秒值
        System.out.println("并行流耗时：" + duration.toMillis());
    }

    private static List<Student> buildData() {
        List<Student> list = new ArrayList<>();
        Random r = new Random();
        // 将对象存入list中
        for (int i = 0 ; i < 100000; i++){
            Student student = new Student(String.valueOf(i),r.nextInt()*100,r.nextInt()*100);
            list.add(student);
        }

        return list;
    }
}
