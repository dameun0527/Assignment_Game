import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseballGame {
    RndNumMaker rndNumMaker;
    int[] randomNumber = new int[3];
    BaseballGameDisplay display = new BaseballGameDisplay();

    public BaseballGame() {
        rndNumMaker = new RndNumMaker();
        randomNumber = rndNumMaker.rndNumMaker();
        System.out.println("생성된 난수: " + randomNumber[0] + ", " + randomNumber[1] + ", " + randomNumber[2]);
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("숫자를 입력하세요.");
            String userInput = scanner.nextLine();

            if (!validateInput(userInput)) {
                display.showInvalidInput();
                continue;
            }
            int strike = countStrike(userInput);

            int ball = countBall(userInput);

            if (strike == 3) {
                display.displayHint(strike, ball);
                display.correctAnswer();
                break;
            } else {
                display.displayHint(strike, ball);
            }
        }
    }

    protected boolean validateInput(String userInput) {
        if (userInput.length() != 3) {
            System.out.println("3자리 수를 입력해주세요.");
            return false;
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isDigit(userInput.charAt(i))) {
                System.out.println("숫자를 입력해주세요.");
                return false;
            }
        }
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) == '0') {
                System.out.println("1부터 9까지의 숫자를 입력해주세요.");
                return false;
            }
        }
        Set<Character> digitSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            if (!digitSet.add(userInput.charAt(i))) {
                System.out.println("각 자리수는 중복될 수 없습니다.");
                return false;
            }
        }
        return true;
    }
    private int countStrike (String input){
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if (input.charAt(i) - '0' == randomNumber[i]) {
                strike++;
            }
        }
        return strike;
    }
    private int countBall (String input){
        int ball = 0;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && input.charAt(j) - '0' == randomNumber[i]) {
                    ball++;
                }
            }
        }
        return ball;
    }
}