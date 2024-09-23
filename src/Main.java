import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 야구 게임에 오신 것을 환영합니다.");
        while (true) {
            System.out.println("원하시는 메뉴의 숫자를 입력하세요.");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 게임 종료하기");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1번을 선택하셨습니다.");
                    System.out.println("게임이 시작되었습니다!");
                    BaseballGame baseballGame = new BaseballGame();
                    baseballGame.play();
                    break;
                case 2:
                    System.out.println("2번을 선택하셨습니다.");
                    System.out.println("아직 구현되지 않은 기능입니다.");
                    break;
                case 3:
                    System.out.println("3번을 선택하셨습니다. 게임을 종료합니다.");
                    scanner.close();
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }
}