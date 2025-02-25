package baseball;

import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현

        System.out.println("args = " + getComputerNumber());
        //        readNumber();

    }

    private static int getComputerNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private static void readNumber() {
        System.out.println("숫자를 입력해주세요");
        Console.readLine();
    }
}
