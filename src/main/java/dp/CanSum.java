package dp;

import java.util.Arrays;
import java.util.Map;

public class CanSum {

    public static boolean calculateRec(int N, int[] terms) {
        if (N == 0) return true;
        if (N < 0) return false;
        return Arrays.stream(terms)
                .mapToObj(i -> calculateRec(N - i, terms))
                .anyMatch(Boolean::booleanValue);
    }

    public static boolean calculate(int N, int[] terms, Map<Integer, Boolean> memo) {
        if (N == 0) return true;
        if (N < 0) return false;
        if (memo.containsKey(N)) return memo.get(N);

        return Arrays.stream(terms)
                .mapToObj(i -> calculateAndMemoize(N, i, terms, memo))
                .anyMatch(Boolean::booleanValue);
    }

    private static boolean calculateAndMemoize(int N, int i, int[] terms, Map<Integer, Boolean> memo) {
        var remainder = N - i;
        var result = calculate(remainder, terms, memo);
        memo.put(remainder, result);

        return result;
    }

}
