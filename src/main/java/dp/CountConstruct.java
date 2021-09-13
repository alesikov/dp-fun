package dp;

import java.util.List;
import java.util.Map;

public class CountConstruct {

    public static Integer analyze(String targetStr, List<String> tokens, Map<String, Integer> memo) {
        if (memo.containsKey(targetStr)) return memo.get(targetStr);
        if (targetStr.length() == 0) return 1;

        var result = tokens.stream()
                .mapToInt(token -> {
                    var startsWithToken = targetStr.startsWith(token);
                    if (!startsWithToken) {
                        return 0;
                    }

                    var substr = targetStr.substring(token.length());
                    return analyze(substr, tokens, memo);
                })
                .sum();

        memo.put(targetStr, result);
        return result;
    }


}
