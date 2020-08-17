package com.urise.webapp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int[] values = new int[]{9, 9, 8, 9, 9, 1, 3};
        System.out.println(minValue(values));
        System.out.println(oddOrEven(array));
    }

    /**
     * Java 8 Streams, task - i.
     */
    public static int minValue(int[] values) {
        IntStream streamFromArrays = Arrays.stream(values);
        int[] mas = streamFromArrays.sorted().distinct().toArray();
        int retval = (int) Math.pow(10, mas.length - 1);
        int sum = 0;
        for (int digit : mas) {
            sum += (retval * digit);
            retval /= 10;
        }
        return sum;
    }

    /**
     * Java 8 Streams, task - ii.
     */
    public static List<Integer> oddOrEven(List<Integer> integers) {
        int count = integers.stream().mapToInt((Int) -> Integer.parseInt(String.valueOf(Int))).sum();
        if (count % 2 == 0) {
            return integers.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        } else {
            return integers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        }
    }

   /* public static void processingOfList(List<Integer> integers, int count) {
        if (count % 2 == 0) {
            integers.stream().filter(x -> x % 2 == 0).;
            for (int i = 0; i < integers.size(); i++) {
                if ((integers.get(i) % 2) == 0) {
                    integers.remove(integers.get(i));
                }
            }
        } else {
            integers.stream().filter(x -> x % 2 != 0);
            for (int i = 0; i < integers.size(); i++) {
                if ((integers.get(i) % 2) != 0) {
                    integers.remove(integers.get(i));
                }
            }
        }
    }*/
}
