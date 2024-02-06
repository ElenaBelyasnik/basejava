package ru.javawebinar.basejava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static javax.swing.UIManager.get;

public class MainStream {
    public static void main(String[] args) {
        System.out.println(minValue(new int[]{1, 2, 3, 3, 2, 3}));
        System.out.println(minValue(new int[]{9, 8}));

        System.out.println(oddOrEven(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(oddOrEven(Arrays.asList(1, 2, 3, 4, 5, 7)));

    }

    public static int minValue(int[] values) {
        return IntStream.of(values).distinct().sorted().reduce(0, (a, b) -> (10 * a + b));
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        return integers
                .stream()
                .filter(integers
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum() % 2 != 0 ? n -> n % 2 == 0 : n -> n % 2 != 0)
                .collect(Collectors.toList());
    }
}
