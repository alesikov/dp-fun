package dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CanConstructTest {

    private static Stream<Arguments> argsProvider() {
        return Stream.of(
                Arguments.of("abcdef", List.of("ab", "abc", "cd", "def", "abcd"), true),
                Arguments.of("zzzz", List.of("ab", "abc", "cd", "def", "abcd"), false),
                Arguments.of("skateboard", List.of("bo", "rd", "ate", "t", "ska", "sk", "boar"), false),
                Arguments.of("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", List.of("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("argsProvider")
    void givenStringTokens_whenCombined_thenTargetStringIsProduced(String targetStr, List<String> tokens, boolean expected) {
        var result = CanConstruct.analyze(targetStr, tokens, new HashMap<>());
        assertThat(result).isEqualTo(expected);
    }

}
