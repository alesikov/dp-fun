package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class HowSum {

    public static List<Integer> howSum(int N, int[] terms) {
        if (N < 0) return null;
        if (N == 0) return new ArrayList<>();

        var result = Arrays.stream(terms)
                .mapToObj(i -> {
                    var remainder = N - i;
                    var tmp = howSum(remainder, terms);
                    if (Objects.nonNull(tmp)) {
                        tmp.add(i);
                    }

                    return tmp;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            return result.stream()
                    .min(Comparator.comparingInt(List::size))
                    .get();
        }
        return null;
    }

    public static List<Integer> howSumDynamic(int N, int[] terms, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(N)) return memo.get(N);
        if (N < 0) return null;
        if (N == 0) return new ArrayList<>();

        var result = Arrays.stream(terms)
                .mapToObj(i -> {
                    var remainder = N - i;
                    var tmp = howSumDynamic(remainder, terms, memo);
                    if (Objects.nonNull(tmp)) {
                        tmp.add(i);
                        var last = memo.get(N);
                        if (last != null) {
                            tmp = tmp.size() > last.size() ? last : tmp;
                        }
                    }

                    memo.put(N, tmp);
                    return memo.get(N);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        if (!result.isEmpty()) {
            return result.stream()
                    .min(Comparator.comparingInt(List::size))
                    .get();
        }
        return null;
    }


}
