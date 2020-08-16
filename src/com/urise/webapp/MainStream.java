package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStream {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        int[] values = new int[]{9, 9, 8, 9, 9, 9, 9};
        minValue(values);
        System.out.println();
        System.out.println(oddOrEven(array));
    }

    /**
     * Java 8 Streams, task - i.
     */
    public static void minValue(int[] values) {
        IntStream streamFromArrays = Arrays.stream(values);
        streamFromArrays.sorted().distinct().forEach(System.out::print);
    }

    /**
     * Java 8 Streams, task - ii.
     */
    public static List<Integer> oddOrEven(List<Integer> integers) {
        int count = integers.stream().mapToInt((Int) -> Integer.parseInt(String.valueOf(Int))).sum();
        processingOfList(integers, count);
        return integers;
    }

    public static void processingOfList(List<Integer> integers, int count) {
        if (count % 2 == 0) {
            for (int i = 0; i < integers.size(); i++) {
                if ((integers.get(i) % 2) == 0) {
                    integers.remove(integers.get(i));
                }
            }
        } else {
            for (int i = 0; i < integers.size(); i++) {
                if ((integers.get(i) % 2) != 0) {
                    integers.remove(integers.get(i));
                }
            }
        }
    }
}
