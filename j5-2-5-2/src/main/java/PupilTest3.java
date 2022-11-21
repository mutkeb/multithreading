import java.util.ArrayList;
import java.util.List;

public class PupilTest3 {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("司音", 75, 1));
        pupils.add(new Pupil("白浅", 80, 0));
        pupils.add(new Pupil("荀飞盏", 95, 8));
        pupils.add(new Pupil("墨渊", 79, 0));
        pupils.add(new Pupil("夜华", 90, 0));
        pupils.add(new Pupil("霓漫天", 81, 0));


        pupils.stream()
                .filter(pupil -> pupil.getViolationCount() == 0 && pupil.getAverageScore() >= 80)
                .map(pupil -> {
                    if (pupil.getAverageScore() > 85){
                        pupil.setMessage(pupil.getName() + "同学您的成绩优秀，恭喜入围");
                    }else if (pupil .getAverageScore() <= 85){
                        pupil.setMessage(pupil.getName() + "同学您的成绩优良，恭喜入围");
                    }
                    return pupil;
                })
                .forEach(System.out::println);
    }
}
