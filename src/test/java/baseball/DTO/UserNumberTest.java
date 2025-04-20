// src/test/java/baseball/DTO/UserNumberTest.java
package baseball.DTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserNumberTest {

    @Test
    @DisplayName("\"123\" 입력 시 내부 Number 배열이 [1,2,3]인지 확인")
    void 내부_배열_확인() {
        // Given
        UserNumber userNumber = new UserNumber("123");

        // When
        Number[] numbers = userNumber.getNumbers();

        // Then
        int[] actual = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            actual[i] = numbers[i].getNumber();
        }
        assertThat(actual).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("방어적 복사: getNumbers()로 받은 배열을 수정해도 원본이 변경되지 않아야 한다")
    void 방어적_복사_테스트() {
        // Given
        UserNumber userNumber = new UserNumber("456");
        Number[] arr1 = userNumber.getNumbers();

        // When
        arr1[0] = Number.createNumber(9);
        Number[] arr2 = userNumber.getNumbers();

        // Then
        assertThat(arr2[0].getNumber()).isEqualTo(4);
    }
}
