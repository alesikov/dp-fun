package dp;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public class GridTraveller {

    public static long calcPathsRec(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        return calcPathsRec(m - 1, n) + calcPathsRec(m, n - 1);
    }

    public static long calcPaths(int m, int n, Map<Pair<Integer, Integer>, Long> memo) {
        if (memo.containsKey(Pair.of(m, n))) return memo.get(Pair.of(m, n));
        if (memo.containsKey(Pair.of(n, m))) return memo.get(Pair.of(n, m));
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;

        var result = calcPaths(m - 1, n, memo) + calcPaths(m, n - 1, memo);
        memo.put(Pair.of(m, n), result);

        return result;
    }

}
