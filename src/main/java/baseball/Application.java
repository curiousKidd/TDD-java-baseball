package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Integer[] computerNumber = getComputerNumber();

        System.out.println("args = " + Arrays.toString(getComputerNumber()));
        //        readNumber();

    }

    // 컴퓨터 번호
    private static Integer[] getComputerNumber() {
        // 중복 방지
        Set<Integer> set = new HashSet<Integer>(3);

        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }

        return set.toArray(new Integer[3]);
    }

    // 사용자 번호 입력
    private static void writeNumber() {
        int[] number = new int[3];
        System.out.println("숫자를 입력해주세요");
        String s = Console.readLine();
        String[] split = s.split("");

        for (int i = 0; i < 3; i++) {
            number[i] = Integer.parseInt(split[i]);
        }

    }

    private static void matchNumber() {

    }
}
