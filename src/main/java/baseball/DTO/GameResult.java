package baseball.DTO;

import java.util.List;

public class GameResult {
    private final List<NumberMatchType> results;

    public GameResult(List<NumberMatchType> results) {
        this.results = results;
    }

    public long strikeCount() {
        return results.stream().filter(r -> r == NumberMatchType.STRIKE).count();
    }

    public long ballCount() {
        return results.stream().filter(r -> r == NumberMatchType.BALL).count();
    }

    public boolean isThreeStrikes() {
        return strikeCount() == 3;
    }

    @Override
    public String toString() {
        if (strikeCount() == 0 && ballCount() == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strikeCount() > 0) {
            sb.append(strikeCount()).append("스트라이크 ");
        }
        if (ballCount() > 0) {
            sb.append(ballCount()).append("볼");
        }
        return sb.toString().trim();
    }
}
