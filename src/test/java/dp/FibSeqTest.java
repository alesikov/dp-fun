package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FibSeqTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3),
                Arguments.of(5, 5),
                Arguments.of(6, 8),
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(11, 89),
                Arguments.of(15, 610)
        );
    }

    @Test
    void givenIndex_thenCalculate() {
        var result = FibSeq.calculateDP(50, new HashMap<>());
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenIndex_whenCalculatedRecursively_thenFibNumberIsReturned(int idx, long expected) {
        assertThat(FibSeq.calculateRecursively(idx)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenIndex_whenCalculatedSeq_thenFibNumberIsReturned(int idx, long expected) {
        assertThat(FibSeq.calculateSequentially(idx)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenIndex_whenCalculatedTab_thenFibNumberIsReturned(int idx, long expected) {
        assertThat(FibSeq.calculateTab(idx)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenIndex_whenCalculatedDP_thenFibNumberIsReturned(int idx, long expected) {
        assertThat(FibSeq.calculateDP(idx, new HashMap<>())).isEqualTo(expected);
    }

}
