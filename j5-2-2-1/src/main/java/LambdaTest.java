import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaTest {
  public static void main(String[] args) {
    List<Animal> animals = Arrays.asList(
            new Animal("Wolf"),
            new Animal("Dog"),
            new Animal("Cat"),
            new Animal("Cattle"),
            new Animal("Chicken")
    );

    Stream<Animal> stream = animals.stream();
    stream.forEach(f->{
      System.out.println(f.getName());
    });

  }
}
