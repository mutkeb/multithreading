import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {

    public static void main(String[] args) {
        List<Integer> evenNumbers = initNumbers();
        evenNumbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
        
    }

    private static List<Integer> initNumbers() {
        List<Integer> evenNumbers = new ArrayList<>();

        int i = 1;
        while (i <= 100) {
            evenNumbers.add((int)(Math.random() * 101));
            i++;
        }

        return evenNumbers;
    }
}
