package dp;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ChangeMakingProblem {

    public static List<Pair<Integer, Long>> calculate(List<Integer> packSizes, int requested) {
        if (packSizes.isEmpty()) return List.of();
        if (requested == 0) return List.of();

        var sorted = new ArrayList<>(packSizes);
        sorted.sort(Comparator.reverseOrder());

        var result = calculate(sorted, requested, new HashMap<>());
        return Optional.ofNullable(result)
                .map(r -> r.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .map(entry -> Pair.of(entry.getKey(), entry.getValue()))
                        .sorted((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey()))
                        .collect(Collectors.toList()))
                .orElseGet(List::of);
    }

    public static List<Integer> calculate(List<Integer> packSizes, int requested, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(requested)) return memo.get(requested);
        if (requested == 0) return new ArrayList<>();
        if (requested < 0) return null;

        var result = packSizes.stream()
                .map(i -> calculateAndMemoize(packSizes, requested, memo, i))
                .filter(Objects::nonNull)
                .findAny();

        return result.orElse(null);
    }

    private static List<Integer> calculateAndMemoize(List<Integer> packSizes, int requested, Map<Integer, List<Integer>> memo, Integer i) {
        var remainder = requested - i;
        var remainderResult = calculate(packSizes, remainder, memo);
        if (Objects.nonNull(remainderResult)) {
            remainderResult.add(i);

            var last = memo.get(remainder);
            remainderResult = (last == null || last.size() > remainderResult.size()) ? remainderResult : last;
        }
        memo.put(remainder, remainderResult);
        return memo.get(remainder);
    }

}
