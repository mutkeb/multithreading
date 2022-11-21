import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PupilTest3 {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        pupils.add(new Pupil("司音", 75, 1));
        pupils.add(new Pupil("白浅", 80, 0));
        pupils.add(new Pupil("荀飞盏", 95, 8));
        pupils.add(new Pupil("墨渊", 79, 0));
        pupils.add(new Pupil("夜华", 90, 0));
        pupils.add(new Pupil("霓漫天", 81, 0));
        pupils.add(new Pupil("江玉燕", 88, 0));
        pupils.add(new Pupil("夏紫熏", 93, 0));
        pupils.add(new Pupil("赵清源", 97, 0));

        Stream<Pupil> stream = pupils.stream();

        stream
          .filter( pupil -> pupil.getAverageScore() >= 80  && pupil.getViolationCount() == 0)
          .map(pupil -> {
              if (pupil.getAverageScore() > 85){
                  pupil.setMessage(pupil.getName() + "同学您的成绩优秀，恭喜入围");
              }else if(pupil.getAverageScore() <= 85){
                  pupil.setMessage(pupil.getName() + "同学您的成绩优良，恭喜入围");
              }
              return pupil;
          })
          .sorted((pupil1,pupil2)->{
             return pupil2.getAverageScore() - pupil1.getAverageScore();
          })
          .limit(3)
          .forEach(pupil -> {
              System.out.println(pupil.getMessage());
          });
    }
}
