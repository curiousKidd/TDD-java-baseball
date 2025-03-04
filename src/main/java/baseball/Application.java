package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        // 컴퓨터 숫자
        Integer[] computerNumber = getComputerNumber();
        System.out.println("computerNumber = " + Arrays.toString(computerNumber));
        boolean b = true;

        do {
            // user 숫자
            int[] userNumbers = writeNumber(computerNumber);

            int[] result = matchNumber(computerNumber, userNumbers);

            StringBuilder sb = new StringBuilder();

            if (result[0] != 0) {
                sb.append(result[0]).append(" 스트라이크 ");
            }
            if (result[1] != 0) {
                sb.append(result[1]).append("볼");
            }
            if (result[0] == 0 && result[1] == 0) {
                sb.append("낫싱");
            }

            System.out.println(sb);

            if (result[0] == 3) {
                System.out.println("게임을 종료하시겠습니까?");
                String endNumber = Console.readLine();

                if (Integer.parseInt(endNumber) == 0) {
                    b = false;
                } else {
                    computerNumber = getComputerNumber();
                }
            }
        } while (b);

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
    private static int[] writeNumber(Integer[] computerNumber) {
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
    private static int[] matchNumber(Integer[] computerNumber, int[] userNumbers) {
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
