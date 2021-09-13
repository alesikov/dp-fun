package dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class AllConstructTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), List.of(List.of("abc", "def"))),
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "ef", "def"), List.of(List.of("abc", "def"), List.of("ab", "cd", "ef"))),
                Arguments.of("purple", List.of("purp", "p", "ur", "le", "purpl"), List.of(List.of("purp", "le"), List.of("p", "ur", "p", "le"))),
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "def", "abcd", "ef", "c"),
                        List.of(
                                List.of("ab", "cd", "ef"),
                                List.of("ab", "c", "def"),
                                List.of("abc", "def"),
                                List.of("abcd", "ef")
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenWordBack_whenTryConstruct_thenOutcomesCountReturned(String targetStr, List<String> wordBank, List<List<String>> expected) {
        var result = AllConstruct.analyze(targetStr, wordBank, new HashMap<String, List<List<String>>>());

        Assertions.assertThat(result.stream()).containsExactlyInAnyOrderElementsOf(expected);
    }

}
