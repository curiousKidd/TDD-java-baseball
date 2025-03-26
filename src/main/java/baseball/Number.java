package baseball;

public class Number {
    static int number;

    private Number() {
    }

    public static Number createNumber(int num) {
        number = num;
        return new Number();
    }

}
