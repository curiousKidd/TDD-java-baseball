package baseball.DTO;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

// 컴퓨터 번호 부분 객체화
public class ComputerNumber {
    private final Number[] numbers;

    public ComputerNumber() {
        this.numbers = generateNumbers();
    }

    private Number[] generateNumbers() {
        Set<Number> set = new LinkedHashSet<>(3);
        while (set.size() < 3) {
            set.add(Number.createNumber(Randoms.pickNumberInRange(1, 9)));
        }
        return set.toArray(new Number[0]);
    }

    public GameResult compare(UserNumber user) {
        int strike = 0, ball = 0;
        Number[] userNumbers = user.getNumbers();

        for (int i = 0; i < 3; i++) {
            if (this.numbers[i].getNumber() == userNumbers[i].getNumber()) {
                strike++;
            } else if (contains(userNumbers[i])) {
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }

    private boolean contains(Number number) {
        for (Number n : this.numbers) {
            if (n.getNumber() == number.getNumber()) return true;
        }
        return false;
    }

    public boolean isStrike(int index, Number userNumber) {
        return numbers[index].equals(userNumber);
    }

    public boolean isBall(int userIndex, Number userNumber) {
        for (int i = 0; i < numbers.length; i++) {
            if (i != userIndex && numbers[i].equals(userNumber)) {
                return true;
            }
        }
        return false;
    }

    public Number[] getNumbers() {
        return numbers.clone(); // 외부에서 수정되지 않도록 방어적 복사
    }
}
