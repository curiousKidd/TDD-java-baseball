package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Application {

    // 게임 반복 boolean
    static boolean b = true;

    // 컴퓨터 숫자
    static Integer[] computerNumber = getComputerNumber();

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        //        System.out.println("computerNumber = " + Arrays.toString(computerNumber));

        do {
            // user 숫자
            int[] userNumbers = setUserWriteNumber();

            // 유저 숫자, 컴퓨터 숫자 비교 및 카운팅
            int[] result = getNumberMatchCount(userNumbers);

            // 결과 출력
            printText(result);

            // 3스트라이크일 경우 재시작 OR 끝낼것인지 체킹
            if (result[0] == 3) {
                gameReloadOrEnd();
            }
        } while (b);

    }

    private static void gameReloadOrEnd() {
        System.out.println("게임을 종료하시겠습니까?");
        System.out.println("1 재시작 | 2 종료");
        String endNumber = Console.readLine();

        if (Integer.parseInt(endNumber) == 1) {
            System.out.println("게임 끝");
            computerNumber = getComputerNumber();
        } else {
            b = false;
        }
    }

    private static void printText(int[] result) {
        StringBuilder sb = new StringBuilder();

        if (result[0] != 0) {
            sb.append(result[0]).append("스트라이크 ");
        }
        if (result[1] != 0) {
            sb.append(result[1]).append("볼");
        }
        if (result[0] == 0 && result[1] == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb);
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
    private static int[] getNumberMatchCount(int[] userNumbers) {
        int[] result = new int[2];
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

        result[0] = strike;
        result[1] = ball;

        //        return ball == 0 && strike == 0 ? "낫싱" : sb.toString();

        return result;
    }

}
