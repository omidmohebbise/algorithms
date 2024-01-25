package org.omidmohebbise.algorithms.search.practice1;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class LinearSearchExample {
    public static void main(String[] args) {


        int[] intArray = IntStream.generate(() -> new Random().nextInt(1, 30))
                .limit(30)
                .distinct().toArray();
        System.out.println("Before sort: " + Arrays.toString(intArray));
        //



        // search the index of 6
        var target = new Random().nextInt(30);
        System.out.printf("The index of %d is equal: %d\n", target, linearSearch(intArray, target));
    }


    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Return the index if the target is found
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }
}