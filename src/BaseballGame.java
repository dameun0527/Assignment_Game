public class BaseballGame {
    private int[] randomNumber;
    private boolean isGameContinue;

    public void play() {
        RndNumMaker rndNumMaker = new RndNumMaker();
        randomNumber = rndNumMaker.RndNumMaker();
        isGameContinue = true;
        System.out.println("숫자 야구 게임을 시작합니다!");
        System.out.println("컴퓨터가 마음속에 숫자를 떠올렸습니다.");

        while (isGameContinue) {
            UserInput userInput = new UserInput();
            int[] userNumbers = userInput.UserInput();

            Results results = new Results();
            isGameContinue = !results.judgement(randomNumber, userNumbers);

            if (!isGameContinue) {
                System.out.println("축하합니다! 정답입니다!");
            }
        }
    }

}