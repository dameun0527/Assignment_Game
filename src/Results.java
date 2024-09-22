public class Results {
    public boolean judgement(int[] randomNumber, int[] userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < userInput.length; j++) {
                if (randomNumber[i] == userInput[j]) {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("Out!");
        } else {
            System.out.println(strike + "S" + ball + "B");
        }
        return strike == 3;
    }
}
