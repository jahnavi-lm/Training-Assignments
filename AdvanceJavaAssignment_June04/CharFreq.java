package AdvanceJavaJune05.AdvanceJavaAssignment_June04;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFreq {
    public static void main(String[] args) {
        String input = "Jahnavi";

        Map<Character, Integer> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.summingInt(c -> 1)
                ));
        frequencyMap.forEach((ch, count) -> System.out.println(ch + " -> " + count));
    }
}
