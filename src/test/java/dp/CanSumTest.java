package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CanSumTest {

    @Test
    void givenValidInput_whenCalculatedRecursively_thenReturnsExpected() {
        var result = CanSum.calculateRec(7, new int[]{5, 4, 3, 7});
        assertThat(result).isTrue();
    }

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(7, new int[]{5, 4, 3, 7}, true),
                Arguments.of(7, new int[]{2, 4}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenValidInput_whenCalculatedDP_thenReturnsExpected(int N, int[] terms, boolean expected) {
        var result = CanSum.calculate(N, terms, new HashMap<>());
        assertThat(result).isEqualTo(expected);
    }

}
