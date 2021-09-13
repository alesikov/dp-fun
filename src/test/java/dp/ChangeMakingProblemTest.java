package dp;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ChangeMakingProblemTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(List.of(5, 3), 0, List.of()),
                Arguments.of(List.of(1), 10, List.of(Pair.of(1, 10L))),
                Arguments.of(List.of(2), 10, List.of(Pair.of(2, 5L))),
                Arguments.of(List.of(3), 10, List.of()),
                Arguments.of(List.of(2, 1), 3, List.of(Pair.of(2, 1L), Pair.of(1, 1L))),
                Arguments.of(List.of(3, 4, 7), 7, List.of(Pair.of(7, 1L))),
                Arguments.of(List.of(2, 3, 5), 8, List.of(Pair.of(5, 1L), Pair.of(3, 1L))),
                Arguments.of(List.of(5, 3), 10, List.of(Pair.of(5, 2L))),
                Arguments.of(List.of(8, 5, 2), 14, List.of(Pair.of(8, 1L), Pair.of(2, 3L))),
                Arguments.of(List.of(9, 5, 3), 13, List.of(Pair.of(5, 2L), Pair.of(3, 1L))),
                Arguments.of(List.of(9, 5, 3), 23, List.of(Pair.of(9, 2L), Pair.of(5, 1L))),
                Arguments.of(List.of(6, 2, 1), 23, List.of(Pair.of(6, 3L), Pair.of(2, 2L), Pair.of(1, 1L))),
                Arguments.of(List.of(1, 2, 5, 25), 100, List.of(Pair.of(25, 4L)))
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenSetOfPackSizesAndTotalAmount_whenCalculated_thenMinAmountOfPacksReturned(List<Integer> packSizes, int requested, List<Pair<Integer, Long>> expected) {
        var result = ChangeMakingProblem.calculate(packSizes, requested);
        assertThat(result).containsExactlyInAnyOrderElementsOf(expected);
    }

}
