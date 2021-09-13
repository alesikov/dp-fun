package dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class HowSumTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(7, new int[]{5, 3, 4}, List.of(3, 4)),
                Arguments.of(7, new int[]{2, 3}, List.of(3, 2, 2)),
                Arguments.of(7, new int[]{7, 2, 6}, List.of(7)),
                Arguments.of(8, new int[]{2, 3, 5}, List.of(3, 5)),
                Arguments.of(7, new int[]{2, 4}, null),
                Arguments.of(300, new int[]{7, 14}, null)
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenInput_whenCalculatedRecursively_thenResultIsExpected(int N, int[] terms, List<Integer> expected) {
        var result = HowSum.howSum(N, terms);
        if (expected == null) {
            Assertions.assertThat(result).isEqualTo(expected);
        } else {
            Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenInput_whenCalculatedDynamically_thenResultIsExpected(int N, int[] terms, List<Integer> expected) {
        var memo = new HashMap<Integer, List<Integer>>();
        var result = HowSum.howSumDynamic(N, terms, memo);
        if (expected == null) {
            Assertions.assertThat(result).isEqualTo(expected);
        } else {
            Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
        }
    }


}
