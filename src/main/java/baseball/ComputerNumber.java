package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

// 컴퓨터 번호 부분 객체화
public class ComputerNumber {
    private final Integer[] numbers;

    public ComputerNumber() {
        this.numbers = generateNumbers();
    }

    private Integer[] generateNumbers() {
        Set<Integer> set = new LinkedHashSet<>(3);
        while (set.size() < 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return set.toArray(new Integer[3]);
    }

    public Integer[] getNumbers() {
        return numbers.clone(); // 외부에서 수정되지 않도록 방어적 복사
    }
}
