// src/test/java/baseball/ApplicationTest.java
package baseball;

import baseball.DTO.ComputerNumber;
import baseball.DTO.GameResult;
import baseball.DTO.NumberMatchType;
import baseball.DTO.UserNumber;
import nextstep.utils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

class ApplicationKiddTest {

    @BeforeEach
    void resetFlag() {
        // 테스트 간 플래그 초기화
        Application.isGameReload = true;
    }

    @Test
    @DisplayName("getNumberMatchCount()는 ComputerNumber.compare() 결과를 그대로 반환한다")
    void getNumberMatchCount_delegation() {
        // Given
        ComputerNumber mockComputer = mock(ComputerNumber.class);
        UserNumber dummyUser = new UserNumber("123");
        // strike 1, ball 2 를 표현하려면 리스트에 STRIKE 하나, BALL 두 개를 넣습니다.
        GameResult expected = new GameResult(
                Arrays.asList(
                        NumberMatchType.STRIKE,
                        NumberMatchType.BALL,
                        NumberMatchType.BALL
                )
        );
        given(mockComputer.compare(dummyUser)).willReturn(expected);

        // When
        GameResult actual = Application.getNumberMatchCount(dummyUser, mockComputer);

        // Then
        assertThat(actual).isSameAs(expected);
        then(mockComputer).should().compare(dummyUser);
    }

    @Test
    @DisplayName("gameReloadOrEnd()에 1 입력 시 isGameReload는 true 유지")
    void gameReloadOrEnd_restart() {
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
            // Given
            console.when(Console::readLine).thenReturn("1");
            Application.isGameReload = true;

            // When
            Application.gameReloadOrEnd();

            // Then
            assertThat(Application.isGameReload).isTrue();
        }
    }

    @Test
    @DisplayName("gameReloadOrEnd()에 2 입력 시 isGameReload는 false로 변경")
    void gameReloadOrEnd_end() {
        try (MockedStatic<Console> console = Mockito.mockStatic(Console.class)) {
            // Given
            console.when(Console::readLine).thenReturn("2");
            //            Application.isGameReload = true;

            // When
            Application.gameReloadOrEnd();

            // Then
            assertThat(Application.isGameReload).isFalse();
        }
    }
}
