package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Application {

    // 게임 반복 boolean
    static boolean isGameReload = true;

    // 컴퓨터 숫자
    static Integer[] computerNumber = getComputerNumber();

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        do {
            // user 숫자
            int[] userNumbers = setUserWriteNumber();

            // 유저 숫자, 컴퓨터 숫자 비교 및 카운팅
            GameResult gameResult = getNumberMatchCount(userNumbers);

            // 결과 출력
            System.out.println(gameResult);

            // 3스트라이크일 경우 재시작 OR 끝낼것인지 체킹
            if (gameResult.isThreeStrikes()) {
                gameReloadOrEnd();
            }
        } while (isGameReload);

    }

    private static void gameReloadOrEnd() {
        System.out.println("게임을 종료하시겠습니까?");
        System.out.println("1 재시작 | 2 종료");
        String endNumber = Console.readLine();

        if (Integer.parseInt(endNumber) == 1) {
            System.out.println("게임 끝");
            computerNumber = getComputerNumber();
        } else {
            isGameReload = false;
        }
    }

    // 컴퓨터 번호
    private static Integer[] getComputerNumber() {
        // 중복 방지
        Set<Integer> set = new LinkedHashSet<>(3);

        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        return set.toArray(new Integer[3]);
    }

    // 사용자 번호 입력
    private static int[] setUserWriteNumber() {
        System.out.println("숫자를 입력해주세요");
        String s = Console.readLine();

        String[] split = s.split("");

        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = Integer.parseInt(split[i]);
        }

        return userNumbers;
    }

    // 번호 매칭
    private static GameResult getNumberMatchCount(int[] userNumbers) {
        int ball = 0, strike = 0;

        for (int i = 0; i < 3; i++) {
            int number = userNumbers[i];

            for (int j = 0; j < 3; j++) {
                if (computerNumber[j] == number && i == j) {
                    strike++;
                    break;

                } else if (computerNumber[j] == number) {
                    ball++;
                    break;
                }
            }
        }

        return new GameResult(strike, ball);
    }

}

class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strikes > 0) {
            sb.append(strikes).append("스트라이크 ");
        }
        if (balls > 0) {
            sb.append(balls).append("볼");
        }
        return sb.toString();
    }
}

