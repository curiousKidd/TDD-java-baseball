package baseball.DTO;

// 컴퓨터 번호 부분 객체화
public class UserNumber {
    private Number[] numbers;

    //    public UserNumber(String s) {
    //        this.numbers = generateNumbers(s);
    //    }
    //
    //    private Number[] generateNumbers(String s) {
    //        String[] split = s.split("");
    //        int[] userNumbers = new int[3];
    //        for (int i = 0; i < 3; i++) {
    //            numbers[i] = Integer.parseInt(split[i]);
    //        }
    //        return numbers;
    //    }

    public Number[] getNumbers() {
        return numbers.clone(); // 외부에서 수정되지 않도록 방어적 복사
    }
}
