package dp;

import java.util.HashMap;
import java.util.Map;

public class FibSeq {

    public static long calculateRecursively(int idx) {
        if (idx == 0) return 0;
        if (idx == 1) return 1;

        return calculateRecursively(idx - 2) + calculateRecursively(idx - 1);
    }

    public static long calculateSequentially(int idx) {
        var result = 0;
        var first = 0;
        var second = 1;
        for (int i = 0; i < idx; i++) {
            result = first + second;
            second = first;
            first = result;
        }

        return result;
    }

    public static long calculateDP(int idx, Map<Integer, Long> memo) {
        if (memo.containsKey(idx)) return memo.get(idx);
        if (idx == 0) return 0;
        if (idx == 1) return 1;

        var fibN = calculateDP(idx - 2, memo) + calculateDP(idx - 1, memo);
        memo.put(idx, fibN);

        return memo.get(idx);
    }

    public static long calculateTab(int idx) {
        var table = new HashMap<Integer, Long>();
        table.put(0, 0L);
        table.put(1, 1L);

        if (idx < 2) {
            return table.get(idx);
        }

        for (int i = 2; i < idx + 1; i++) {
            var tmp = table.get(i - 1) + table.get(i - 2);
            table.put(i, tmp);
        }

        return table.get(idx);
    }

}
