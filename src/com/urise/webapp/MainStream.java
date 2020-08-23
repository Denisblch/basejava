package com.urise.webapp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int[] values = new int[]{9, 9, 8, 9, 9, 1, 9};
        System.out.println(minValue(values));
        System.out.println(oddOrEven(array));
    }

    /**
     * Java 8 Streams, task - i.
     */
    public static int minValue(int[] values) {
        IntStream streamFromArrays = Arrays.stream(values);
        return streamFromArrays.sorted().distinct().reduce(0, (x, y) -> (10 * x) + y);
    }

    /**
     * Java 8 Streams, task - ii.
     */
    public static List<Integer> oddOrEven(List<Integer> integers) {
        int count = integers.stream().mapToInt((Int) -> Integer.parseInt(String.valueOf(Int))).sum();
        return integers.stream().filter(x -> count % 2 != x % 2).collect(Collectors.toList());
    }
}
