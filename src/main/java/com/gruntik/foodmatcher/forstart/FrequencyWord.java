package com.gruntik.foodmatcher.forstart;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FrequencyWord {

    public static Map<String, Integer> getMostFrequencyWord(List<String> wordArray) {
        return wordArray.stream()
                .collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
    }

    public static Map<String, Integer> sortMap(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static String getFirstColorFromMap(Map<String, Integer> map) {
        return map.keySet().stream().findFirst().get();
    }


}
