package baseball.DTO;

public class Number {
    private final int number;

    private Number(int num) {
        this.number = num;
    }

    public static Number createNumber(int num) {
        return new Number(num);
    }

    public int getNumber() {
        return number;
    }

}
