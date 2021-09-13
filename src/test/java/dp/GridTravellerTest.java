package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTravellerTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of(0, 1, 0),
                Arguments.of(1, 0, 0),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 1),
                Arguments.of(1, 2, 1),
                Arguments.of(3, 1, 1),
                Arguments.of(1, 3, 1),
                Arguments.of(2, 3, 3),
                Arguments.of(3, 2, 3),
                Arguments.of(18, 18, 2333606220L)
        );
    }

    @Test
    void givenNM_thenCalculateNumberOfPaths() {
        var result = GridTraveller.calcPaths(3, 3, new HashMap<>());
        System.out.println(result);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenNMRectangle_whenCalculated_thenNumberOfPathsReturned(int n, int m, long expected) {
        assertThat(GridTraveller.calcPaths(n, m, new HashMap<>())).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenNMRectangle_whenCalculatedRec_thenNumberOfPathsReturned(int n, int m, long expected) {
        assertThat(GridTraveller.calcPathsRec(n, m)).isEqualTo(expected);
    }

}
