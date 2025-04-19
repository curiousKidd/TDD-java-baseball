package baseball.DTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    @Test
    @DisplayName("결과 리스트가 모두 STRIKE면 isThreeStrikes()는 true를 반환한다")
    void 스트라이크_3개_사실() {
        // Given
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.STRIKE,
                        NumberMatchType.STRIKE,
                        NumberMatchType.STRIKE
                )
        );

        // When & Then
        assertThat(result.strikeCount()).isEqualTo(3);
        assertThat(result.ballCount()).isEqualTo(0);
        assertThat(result.isThreeStrikes()).isTrue();
    }

    @Test
    @DisplayName("스트라이크가 3개 미만이면 isThreeStrikes()는 false를 반환한다")
    void 스트라이크_3개_거짓() {
        // Given (2 strikes, 1 ball)
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.STRIKE,
                        NumberMatchType.STRIKE,
                        NumberMatchType.BALL
                )
        );

        // When & Then
        assertThat(result.strikeCount()).isEqualTo(2);
        assertThat(result.ballCount()).isEqualTo(1);
        assertThat(result.isThreeStrikes()).isFalse();
    }

    @Test
    @DisplayName("스트라이크·볼 모두 없으면 toString()은 \"낫싱\"을 반환한다")
    void 낫싱_반환_테스트() {
        // Given
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.NOTHING,
                        NumberMatchType.NOTHING,
                        NumberMatchType.NOTHING
                )
        );

        // When & Then
        assertThat(result.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("스트라이크만 있을 때 toString()은 \"n스트라이크\"를 반환한다")
    void toString_onlyStrikes() {
        // Given (1 strike)
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.STRIKE,
                        NumberMatchType.NOTHING,
                        NumberMatchType.NOTHING
                )
        );

        // When & Then
        assertThat(result.toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("볼만 있을 때 toString()은 \"n볼\"을 반환한다")
    void toString_onlyBalls() {
        // Given (2 balls)
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.BALL,
                        NumberMatchType.BALL,
                        NumberMatchType.NOTHING
                )
        );

        // When & Then
        assertThat(result.toString()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("스트라이크와 볼이 모두 있을 때 toString()은 \"x스트라이크 y볼\"을 반환한다")
    void toString_strikesAndBalls() {
        // Given (2 strikes, 1 ball)
        GameResult result = new GameResult(
                Arrays.asList(
                        NumberMatchType.STRIKE,
                        NumberMatchType.STRIKE,
                        NumberMatchType.BALL
                )
        );

        // When & Then
        assertThat(result.toString()).isEqualTo("2스트라이크 1볼");
    }
}

