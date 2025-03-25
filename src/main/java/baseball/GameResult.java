package baseball;

public class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isThreeStrikes() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strikes > 0) {
            sb.append(strikes).append("스트라이크 ");
        }
        if (balls > 0) {
            sb.append(balls).append("볼");
        }
        return sb.toString().trim();
    }
}
