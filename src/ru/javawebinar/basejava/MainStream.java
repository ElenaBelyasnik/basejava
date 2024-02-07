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
        // реализовать метод через стрим int minValue(int[] values).
        // Метод принимает массив цифр от 1 до 9, надо выбрать уникальные и вернуть
        // минимально возможное число, составленное из этих уникальных цифр.
        // Не использовать преобразование в строку и обратно.
        // Например {1,2,3,3,2,3} вернет 123, а {9,8} вернет 89
        System.out.println(minValue(new int[]{1, 2, 3, 3, 2, 3}));
        System.out.println(minValue(new int[]{9, 8}));

        // реализовать метод List<Integer> oddOrEven(List<Integer> integers)
        // если сумма всех чисел нечетная - удалить все нечетные, если четная -
        // удалить все четные. Сложность алгоритма должна быть O(N).
        // Optional - решение в один стрим.
        System.out.println(oddOrEven(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(oddOrEven(Arrays.asList(1, 2, 3, 4, 5, 7)));

    }

    public static int minValue(int[] values) {
        return IntStream.of(values)
                .distinct()
                .sorted()
                .reduce(0, (a, b) -> (10 * a + b));
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        Map<Boolean, List<Integer>> map = integers.stream()
                .collect(partitioningBy(x -> x % 2 == 0, toList()));
        return map.get(map.get(false).size() % 2 != 0);
    }
}
