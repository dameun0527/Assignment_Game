import java.util.*;

public class UserInput {
    int[] userInput = new int[3];
    Scanner sc = new Scanner(System.in);

    public int[] UserInput() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("숫자를 입력해주세요.");
                Set<Integer> inputNumbers = new HashSet<>();

                for (int i = 0; i < 3; i++) {
                    int num = sc.nextInt();
                    if (num < 1 || num > 9) {
                        System.out.println(" 1부터 9 사이의 숫자만 입력해주세요.");
                        i--;
                    } else if (!inputNumbers.add(num)) {
                        System.out.println("중복된 숫자는 입력할 수 없습니다.");
                        i--;
                    }
                }
                int i = 0;
                for (int num : inputNumbers) {
                    userInput[i++] = num;
                }
                validInput = true;

            } catch (InputMismatchException e) {
                // 숫자가 아닌 값을 입력했을 때 예외 처리
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                sc.next(); // 잘못된 입력값을 버림
            }
        }
        return userInput;
    }
}

