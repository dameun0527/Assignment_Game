import java.util.*;
public class NumberGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> answers = new HashSet<>();
        int[] selectNumbers = new int[3];

        int i = 0;
        while (answers.size() < 3) {
            int number = random.nextInt(9) + 1;
            if (answers.add(number)) {
                selectNumbers[i++] = number;
            }
        }
//        System.out.println("3자리 숫자: " + selectNumbers[0] + selectNumbers[1] + selectNumbers[2]);
    }
}
