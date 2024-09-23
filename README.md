# [Spring 3기] Ch 2. 숫자 야구 게임

![img.jpg](img.jpg)

# 📁 과제 소개

계산기 과제에서 살짝 맛 보았던 **객체 지향성**을 본격적으로 다루어볼 수 있는 과제다. 대략적으로 알고 있던 개념을 조금 더 구체화하고 내 것으로 만들어보자.

## 🌏 개발 환경

- Java (JDK) 17.0.12
- IDE: IntelliJ IDEA Ultimate


## ⏲ 개발 기간
#### < Task Progress >

|        Date         | Progress                                        |
|:-------------------:|-------------------------------------------------|
| 24.09.12 ~ 24.09.14 | 과제 발제 이후 개인 과제 요구 사항 이해<br>배운 내용 및 이해 안되는 부분 복습 |
| 24.09.15 ~ 24.09.18 | 추석 연휴 > 컨디션 관리 및 휴식                             |
| 24.09.19 ~ 24.09.20 | 과제 기획, 설계 및 개발편 작성                              |
| 24.09.21 ~ 24.09.23 | 코드 작성 및 수정 완료, README 작성, 트러블 슈팅                |
| 24.09.24 ~  | 과제 제출                                           |

## 📋 목차

1️⃣ 기획편

2️⃣ 설계 및 개발편 - 단계별 필수 기능 구현 과정
- [설계 초안](#-설계-초안-)
- [Step 1. 필수 기능: Lv 1.](#lv-1-기본-게임-구현숫자-야구-게임)
- [Step 2. 필수 기능: Lv 2.](#lv-2-입력-및-출력-개선)
- [Step 2. 도전 기능: Lv 3.] - 미완성

3️⃣ [고찰 및 회고 편 - 힘들거나 어려웠던 부분 및 소감](#3-고찰-및-회고-편)

<br>

### 1️⃣ 기획편

1. 과제에 대한 이해를 위해 사전 조사
   - '숫자 야구 게임'이 무엇인지

2. 간단히 생각해본 기능
   - 랜덤으로 3자리, 혹은 4자리 숫자 뽑기

   - 정답이 되는 3자리, 혹은 4자리의 숫자를 저장하기

   - 매 회 숫자를 입력하면 저장된 정답을 호출해서 각 자리수의 값이 일치하는지 결과 표현
   - 단, 결과 표현은 일치하는 값의 개수에 따라 '볼'과 '스트라이크', '아웃'을 구현하는 것으로 함.




###  2️⃣ 설계 및 개발편

이번에는 저번 계산기 과제와는 달리, 좀 더 생각을 구체적으로 했다. 모든 과정은 블로그에 자세하게 기재했다.

[[[Spring 3기] CH 2. 숫자 야구 게임 과제 - 설계 및 개발편 (1)]](https://jisuryu0527.tistory.com/46)

[[[Spring 3기] CH 2. 숫자 야구 게임 과제 - 설계 및 개발편 (2)]](https://jisuryu0527.tistory.com/47)

#### **< 설계 초안 >**

1. 코드랑 연관시켜서 키워드 뽑기.
   1) 숫자 정하기(컴퓨터가 정함)
      - 랜덤 뽑기: `random`, `hashset`
      - 3자리 수: 100x+10y+z
      - 각 자리수는 1부터 9까지 + 중복 없음: (0 < x, y, z < 10, x =/ y, y =/ z, z =/ x)
      - 뽑은 값 저장: 반환 타입은? 숫자니까 int
   2) 사용자의 입력값 처리
      - 회차별 입력값 저장: 어떤 자료구조를 쓸지
   3) 입력값과 저장된 값(1에서 랜덤으로 정했던 값)을 비교하여 결과를 도출할 로직 설정
      - 최대 회차는 9까지: n < 9
      - '볼'과 '스트라이크'로 루트 나누기: switch
      - '볼'이 나올 수 있는 로직: if / else if
      - '스트라이크'가 나올 수 있는 로직 if / else if
      - '아웃'이 나올 수 있는 로직은 위 두가지 제외...?
   4) 입력한 값과 결과값을 비교하여 '볼'과 '스트라이크', '아웃'으로 구현
      - 정답을 맞출 때(3B)까지 계속 시도: while
      - 정답을 맞출 경우 축하 메시지 출력: getResults? equals?
   5) 예외처리: Try-Catch
      - 입력 과정에서 생기는 예외: 유효하지 않은 값일 경우
         - 중복된 숫자를 입력했을 때
         - 숫자가 아닌 문자를 입력했을 때 NumberFormatException
         - 0을 입력했을 때: Exception - 좀 더 세부적인?
      - 9회차를 초과할 때까지 값을 찾아내지 못했을 때?

2. 기능별로 클래스 나누기.
   1) Main - 사용자를 위한 입출력 관련 기능
   2) GameRule - '볼' / '스트라이크' / '아웃' 구분하는 로직
   3) NumberGenerator - 랜덤 숫자 생성기
   4) Results - 결과값(볼, 스트라이크 등) 저장
   5) ValidNumber - 유효값 검증


#### **< 설계 최종본 >**


1. Main 클래스: 숫자 야구 게임의 진입점
   - 주요 기능
     1. 게임 시작하기: BaseballGame 클래스를 호출하여 게임 시작
     2. 게임 기록 보기: 추후 구현될 기능
     3. 게임 종료: 프로그램 종료
2. RndNumMaker 클래스: 난수 생성 기능
   - 주요 기능
     1. Set을 사용하여 중복없는 1~9 사이의 3자리 난수 생성 후 배열로 반환
     2. Collections.shuffle 기능: 무작위로 리스트에 있는 요소 섞기
3. BaseballGameDisplay 클래스: 사용자와의 상호작용 처리
   - 주요 기능
     1. 입력값에 오류가 생겼을 때 경고 메시지 출력하기
     2. 현재 사용자의 입력에 대한 스트라이크와 볼 개수 힌트로 출력
     3. 정답일 경우 메시지 출력
4. BaseballGame 클래스: 숫자 야구 게임의 핵심 로직 처리 
   - 주요 기능
     1. play(): 게임의 메인 루프 실행
        - 사용자 입력 처리 및 입력값 유효성 검사
        - 스트라이크 / 볼 개수 계산
        - 답을 맞출 때 까지 반복
     2. validateInput(): 사용자 입력값이 조건에 부합한지(1~9 사이의 중복되지 않는 3자리 수) 검사
     3. countStrike(): 입력값과 정답 비교 후 스트라이크 개수 계산
     4. countBall(): 입력값과 정답 비교 후 볼 개수 계산



#### Step 1. 필수 기능 가이드
##### **Lv 1. 기본 게임 구현(숫자 야구 게임)**


[Main.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
public class Main {
   public static void main(String[] args) {
      BaseballGame baseballGame = new BaseballGame();
      baseballGame.play();
   }
}
```

</details>

✔ About Main.java

1. BaseballGame 클래스에서 게임 시작 메소드 호출
2. 세부적인 설계하기
    - 항목별 주요 키워드
        - BaseballGame 클래스의 객체 인스턴스화



[RndNumMaker.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
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
```

</details>

✔ About RndNumMaker.java

1. 서로 다른 3자리 난수를 생성
2. 세부적인 설계하기
   - 항목별 주요 키워드
      - 필드: `int[]` 난수 저장 배열
      - 메소드:`HashSet<>()`, `Random`, `.size()`,`while`
      - Set 배열 저장 보완: `Iterator`
      - 추가 대안: `Collections.shuffle`



[BaseballGameDisplay.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
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
```

</details>

✔ About BaseballGameDisplay.java

1. 숫자 야구 게임의 출력 담당 
2. 세부적인 설계하기
    - 항목별 주요 키워드
        - `showInvalidInput`: 잘못된 입력 상태 전달을 위한 오류 메시지 출력
        - `displayHint`: 스트라이크, 볼 개수 출력
        - `correctAnswer`: 정답을 맞췄을 때 정답 메시지 출력



[BaseballGame.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
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
```

</details>

✔ About BaseballGame.java

1. 숫자 야구 게임의 핵심 로직 구현
2. 세부적인 설계하기
    - 항목별 주요 키워드
        - 필드: 난수 생성 담당 클래스의 인스턴스 / 생성된 3자리 난수 저장 배열 / 게임 출력 담당 클래스의 인스턴스
        - 생성자: 게임 시작 시 난수 생성 후 초기화
        - play(): 게임 진행 메소드
        - validateInput(): 사용자 입력값 유효성 검사 메소드
        - countStrike(): 스트라이크 개수 계산
        - countBall(): 볼 개수 계산




##### **Lv 2. 입력 및 출력 개선**

유효성 검사는 예외 처리를 하면서 Lv 1 구현 과정에 이미 마무리했기 때문에, 새로 추가된 **출력 개선 기능만** 작성함.



[Main.java]
<details>
<summary> 코드 전체 확인하기 </summary>

```java
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
```


</details>

✔ About upgraded Main

1. 게임 메뉴 기능 추가
2. 세부적인 설계하기
    - 항목별 주요 키워드
        - 루트 분할: `switch`
        - 루프 생성: `while`
        - 예외 처리: `default` (원래 default가 예외 처리를 위한 것은 아니나, 이번엔 그 용도로 써서 이렇게 기재함.)
        - 루프 종료: `if` 조건문



#### Step 2. 도전 기능 가이드


후에 시간이 된다면 좀 더 공부해서 도전해보기로 함.

###  3️⃣ 고찰 및 회고편
#### 회고

[[자세한 이야기는 블로그로.]](https://jisuryu0527.tistory.com/48)

처음 기능에 따라 클래스를 세분화하는 것까진 괜찮았는데, 직접 메소드를 작성하려니 그 부분부터 막혔다. 그리고 메소드 작성을 끝내더라도, 각 클래스에서 메소드를 어떤식으로 호출할지도 감이 잡히질 않았다. 객체 생성을 어느 부분에 해야 가장 효율적인지, 메소드 내에서 데이터 흐름을 어떻게 가져갈지 같은 부분도 문제였다.

이 부분에 대해서는 아마, 계속 코딩을 해보면서 경험을 쌓는 것 밖에는 현재로서 답이 없다는 생각이 들었다. 코딩 컨벤션이라고 주로 필드 > 생성자 > 메소드 순으로 맞춰야하는데 그 큰 구조 내에서도 가장 효율적인 나만의 방법을 찾아야할 것 같다.



#### 개선하고 싶은 점이 있다면?

1. 예외 처리에 대해

   이번엔 예외 처리를 이전 과제보다 꼼꼼하게 보질 못했다. 다른 필수 기능을 구현하는 것이 더 급선무라고 생각했기 때문이다. 일단 과제 제출 준비를 마무리한 다음, 다시 코드를 살펴보면서 고쳐야할 부분은 고치고, 시간이 된다면 도전 과제까지 손대보려고 한다.


2. 좀 더 객체 지향적일 순 없을까?
   
    처음 내가 의도한 대로 하나에 클래스에서 하나의 기능만 담당하도록 만들어보고 싶다. 
