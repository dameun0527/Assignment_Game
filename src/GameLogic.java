import java.util.*;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class GameLogic {
    private int[] randNum = new int[3];
    private int[] usersInput;
    private int strike;
    private int ball;
    private int out;

    // 게임 시작 메소드
    public void playStart() {
        getRandNum(); // 난수 생성
    }

    // 난수 생성 메소드
    private void getRandNum() {
        Set<Integer> rndNumSet = new HashSet<>();
        Random random = new Random();

        // 각 자리의 수가 1부터 9까지인 3자리 난수 만들기
        while (rndNumSet.size() < 3) {
            int number = random.nextInt(9) + 1;
            rndNumSet.add(number);
        }
        // Set 자료를 배열에 저장
        // 이유 1: HashSet에서는 순서를 보장하지 않기 때문
        // 이유 2: 직접적 인덱스 참조 불가 > 배열은 가능하므로
        Iterator<Integer> iterator = rndNumSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            randNum[i++] = iterator.next();
        }

        // 데이터 섞기?

    }
}