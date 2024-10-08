import java.util.*;

public class RndNumMaker {
    int[] randomNumber = new int[3];

    public int[] rndNumMaker() {
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
            randomNumber[i++] = iterator.next();
        }
        return randomNumber;
        //Tip: collections.shuffle 이용해 데이터를 섞기
//        List<Integer> rndNumSet = new ArrayList<>();
//        for (int i = 1; i <= 9; i++) {
//            rndNumSet.add(i);
//        }
//        Collections.shuffle(rndNumSet);
//
//        int[] randomNumber = new int[3];
//        for (int i = 0; i < 3; i++) {
//            randomNumber[i] = rndNumSet.get(i);
//        }
//        return randomNumber;

    }


}
