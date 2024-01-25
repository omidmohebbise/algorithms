package org.omidmohebbise.algorithms.practice1;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/*
Binary search is an efficient algorithm for finding a specific value in a sorted array.
 The idea behind binary search is to repeatedly divide the search interval in half.
 It begins by comparing the target value to the middle element of the array.
 If the target value is equal to the middle element, the search is successful.
 If the target is less than the middle element, the search continues in the lower half; otherwise, it continues in the upper half.
 This process is repeated until the target element is found or the search interval is empty.
 */
public class BinarySearchExample {
    public static void main(String[] args) {


        int[] intArray = IntStream.generate(() -> new Random().nextInt(1, 100))
                .limit(30)
                .distinct().toArray();
        System.out.println("before sort: " + Arrays.toString(intArray));
        //

        //binary search only worked on sorted arrays
        Arrays.sort(intArray);
        System.out.println("After sort: " + Arrays.toString(intArray));

        // search the index of 6
        var target = new Random().nextInt(30);
        System.out.printf("The index of %d is equal: %d\n", target, binarySearchWithLoop(intArray, target));
        System.out.printf("the index of %d is equal: %d  \n", target, binarySearchWithRecursive(intArray, target, 0, intArray.length));
    }


    private static int binarySearchWithLoop(int[] intArray, int searchedValue) {
        int low = 0;
        int high = intArray.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (intArray[mid] == searchedValue)
                return mid;
            else if (intArray[mid] > searchedValue) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchWithRecursive(int[] intArray, int searchedValue, int low, int high) {
        if (low == high)
            return intArray[low] == searchedValue ? low : -1;

        int mid = low + (high - low) / 2;

        if (intArray[mid] == searchedValue)
            return mid;
        else if (intArray[mid] > searchedValue) {
            return binarySearchWithRecursive(intArray, searchedValue, low, mid - 1);
        } else {
            return binarySearchWithRecursive(intArray, searchedValue, mid + 1, high);
        }
    }
}