package dp;

import java.util.List;
import java.util.Map;

public class CanConstruct {

    public static boolean analyze(String targetStr, List<String> tokens, Map<String, Boolean> memo) {
        if (memo.containsKey(targetStr)) return memo.get(targetStr);
        if (targetStr.length() == 0) {
            return true;
        }

        var result = tokens.stream()
                .anyMatch(token -> {
                    var startsWithToken = targetStr.startsWith(token);
                    if (!startsWithToken) {
                        return false;
                    }

                    var substr = targetStr.substring(token.length());
                    return analyze(substr, tokens, memo);
                });

        memo.put(targetStr, result);
        return result;
    }

}
