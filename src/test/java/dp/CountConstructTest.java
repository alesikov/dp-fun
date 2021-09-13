package dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class CountConstructTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), 1),
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "ef", "def"), 2),
                Arguments.of("purple", List.of("purp", "p", "ur", "le", "purpl"), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenWordBack_whenTryConstruct_thenOutcomesCountReturned(String targetStr, List<String> wordBank, int expected) {
        var result = CountConstruct.analyze(targetStr, wordBank, new HashMap<>());

        Assertions.assertThat(result).isEqualTo(expected);
    }

}
