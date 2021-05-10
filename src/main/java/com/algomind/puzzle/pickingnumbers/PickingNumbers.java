package com.algomind.puzzle.pickingnumbers;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class PickingNumbers {
    public int pickingNumbers(List<Integer> input) {
        Map<Integer, Long> frequencyMap = input.stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> numbers = frequencyMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        int singleResult = frequencyMap.values().stream()
                .mapToInt(Long::intValue)
                .filter(n -> n > 2)
                .max().orElse(0);

        List<int[]> pairs = IntStream.range(0, numbers.size() - 1).boxed()
                .map(i -> new int[]{numbers.get(i), numbers.get(i + 1)})
                .filter(pair -> Math.abs(pair[1] - pair[0]) == 1)
                .collect(Collectors.toList());

        int resultPair = pairs.stream()
                .mapToInt(pair -> frequencyMap.get(pair[0]).intValue() + frequencyMap.get(pair[1]).intValue())
                .max()
                .orElse(0);

        return Math.max(singleResult, resultPair);
    }
}
