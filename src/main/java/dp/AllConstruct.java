package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AllConstruct {

    public static List<List<String>> analyze(String targetStr, List<String> tokens, Map<String, List<List<String>>> memo) {
        if (memo.containsKey(targetStr)) {
            return memo.get(targetStr);
        }

        if (targetStr.length() == 0) {
            var arr = new ArrayList<List<String>>();
            arr.add(new ArrayList<String>());

            return arr;
        }

        var result = tokens.stream()
                .map(token -> {
                    var startsWithToken = targetStr.startsWith(token);
                    if (!startsWithToken) {
                        return new ArrayList<List<String>>();
                    }

                    var substr = targetStr.substring(token.length());
                    List<List<String>> tokenResult = analyze(substr, tokens, memo);
                    return tokenResult.stream().map(subList -> {
                        List<String> newList = new ArrayList<String>();
                        newList.add(token);
                        newList.addAll(subList);

                        return newList;
                    }).collect(Collectors.toList());
                })
                .filter(list -> !list.isEmpty())
                .flatMap(List::stream)
                .collect(Collectors.toList());

        memo.put(targetStr, result);
        return result;
    }

}
