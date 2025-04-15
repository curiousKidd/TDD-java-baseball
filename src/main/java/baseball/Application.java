package baseball;

import baseball.DTO.ComputerNumber;
import baseball.DTO.GameResult;
import baseball.DTO.Number;
import baseball.DTO.UserNumber;
import nextstep.utils.Console;

public class Application {

    // 게임 반복 boolean
    static boolean isGameReload = true;

    public static void main(String[] args) {
        do {
            // 새로운 게임 시작 (새로운 ComputerNumber 객체 생성)
            ComputerNumber computerNumber = new ComputerNumber();
            playGame(computerNumber);
        } while (isGameReload);
    }

    // 기존 게임 로직 method 변경
    private static void playGame(ComputerNumber computerNumber) {
        while (true) {
            // 사용자 숫자 입력
            UserNumber userNumber = setUserNumber();

            // 유저 숫자, 컴퓨터 숫자 비교 및 카운팅
            GameResult gameResult = getNumberMatchCount(userNumber, computerNumber);

            // 결과 출력
            System.out.println(gameResult);

            // 3스트라이크일 경우 재시작 OR 끝낼것인지 체킹
            if (gameResult.isThreeStrikes()) {
                gameReloadOrEnd();
                break;
            }
        }
    }

    private static void gameReloadOrEnd() {
        System.out.println("게임을 종료하시겠습니까?");
        System.out.println("1 재시작 | 2 종료");
        String endNumber = Console.readLine();

        if (Integer.parseInt(endNumber) == 1) {
            System.out.println("게임 끝");
        } else {
            isGameReload = false;
        }
    }

    // 사용자 번호 입력
    private static UserNumber setUserNumber() {
        System.out.println("숫자를 입력해주세요");
        String userNumbersText = Console.readLine();

        UserNumber userNumber = new UserNumber(userNumbersText);
        return userNumber;
    }

    // 번호 매칭
    private static GameResult getNumberMatchCount(UserNumber userNumbers, ComputerNumber computerNumber) {
        int ball = 0, strike = 0;
        Number[] computerNumberNumbers = computerNumber.getNumbers();
        Number[] userNumbersNumbers = userNumbers.getNumbers();
        for (int i = 0; i < 3; i++) {
            int number = userNumbersNumbers[i].getNumber();
            for (int j = 0; j < 3; j++) {
                if (computerNumberNumbers[j].getNumber() == number && i == j) {
                    strike++;
                    break;
                } else if (computerNumberNumbers[j].getNumber() == number) {
                    ball++;
                    break;
                }
            }
        }
        return new GameResult(strike, ball);
    }
}