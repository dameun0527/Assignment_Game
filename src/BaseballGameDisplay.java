public class BaseballGameDisplay {

    public void showInvalidInput() {
        System.out.println("올바르지 않은 입력값입니다.");
    }

    public void displayHint(int strike, int ball) {
        System.out.println(strike + "S " + ball + "B");
    }

    public void correctAnswer() {
        System.out.println("정답입니다!");
    }
}