package com.data.structures.algorithms.geek.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class CustomArrays {

    public static void printArray(int[] arr) {
        for (int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }
    public static int largestIndex(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }
        return res;
    }

    public static int secondLargestIndex(int[] arr) {

        if (arr.length <= 1) {
            return -1;
        }

        int res = 0;
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] > arr[res]) {
                res = i;
            }
        }
        return res;
    }

    public static int[] reverseArray(int[] arr) {
        int low = 0; int high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = temp;
        }
        for (int a: arr) {
            System.out.print(a + " ");
        }
        return arr;
    }

    public static int[] moveZeroes(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        for (int a: arr)
            System.out.print(a + " ");
        return arr;
    }

    public static int maxDiff(int[] arr) {
        if (arr.length <= 1) {
            return -1;
        }
        if (arr.length == 2) {
            return arr[1] - arr[0];
        }

        int res = arr[1] - arr[0], minVal = arr[0];

        for(int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - minVal);
            minVal = Math.min(minVal, arr[i]);
        }
        return res;
    }

    public static int maxProfits(int arr[]) {
        if (arr.length <= 1) {
            return 0;
        }

        int profit = 0;
        boolean inPosition = false;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i-1]) {
                profit += (arr[i] - arr[i-1]);
                if(!inPosition) {
                     System.out.println("Buy at " + arr[i-1]);
                     inPosition = true;
                }
            }
            else {
                System.out.println("Sell at " + arr[i - 1]);
                inPosition = false;
            }
        }
        if (inPosition) {
            System.out.println("Sell at " + arr[arr.length - 1]);
        }
        return profit;

    }

    public static void freqSortedArray(int [] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0] + "- 1 times");
            return;
        }
        int n = arr.length;
        int i = 1;
        int freq = 1;
        while(i < n) {
            while(i < n && arr[i-1] == arr[i]) {
                freq++;
                i++;
            }
            System.out.println(arr[i-1] + " - " + freq + "times");
            i++;
            freq = 1;
        }
        if (arr[n-1] != arr[n-2]) {
            System.out.println(arr[n-1] + " - 1 times");
        }
    }

    public static int trappingRainWater(int[] arr) {
        int units=0;

        int[] rmax = new int[arr.length], lmax = new int[arr.length];
        rmax[arr.length-1] = arr[arr.length-1];
        lmax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i+1], arr[i]);
        }
        printArray(rmax);
        printArray(lmax);
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            res += Math.min(lmax[i], rmax[i]) - arr[i];
        }

        return res;
    }

    public static int maxConsecutiveNum(int[] arr, int n) {
        int countMax = 0;
        int tempCounter = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                tempCounter++;
            } else if (countMax < tempCounter) {
                countMax = tempCounter;
                tempCounter = 0;
            }
        }
        return countMax;
    }

    public static int betBalance(String str) {
        int sum = 4;
        int initialBet = 1;
        char[] string = str.toCharArray();
        for (char c: string) {
            if (sum < initialBet) return -1;
            if (c == 'W') {
                System.out.println("Win!! Sum: " + sum + " bet: " + initialBet);
                sum += initialBet;
                initialBet = 1;
            } else {
                System.out.println("Loss!! Sum: " + sum + " bet: " + initialBet);
                sum -= initialBet;
                initialBet = initialBet * 2;
            }
        }
        return sum;
    }

    public static void frequencyCount(int arr[], int N, int P)
    {
        for(int i = 0 ; i < N ; i++)
            if((arr[i] - 1) % (P+1) < N) {
                System.out.println((arr[i] - 1) % (P + 1));
                arr[(arr[i] - 1) % (P + 1)] += P + 1;
            }
        printArray(arr);
        for(int i = 0 ; i < N ; i++)
            arr[i] /= P+1;
        printArray(arr);
    }


    public static ArrayList<Integer> leaders(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int d = 1;
        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                result.add(arr[i]);
            }
        }
        Collections.reverse(result);
        return result;
    }


    public static int maxSumSubArray(int[] arr) {
        int res = arr[0];
        int maxArray = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxArray = Math.max(maxArray + arr[i], arr[i]);
            res = Math.max(res, maxArray);
        }
        return res;
    }

    public static int minSumSubArray(int[] arr) {
        int res = arr[0], minArray = arr[0];
        for(int i = 0; i < arr.length; i++) {
            minArray = Math.min(minArray, minArray - arr[i]);
            res = Math.min(minArray, res);
        }
        return res;
    }

    /**
     * 1. Calculate normal sum
     * 2. Calculate circular sum
     *     i. Calculate total sum
     *     ii. Calculate minimum sum
     *     iii. Circular sum = Total sum - minimum Sum
     * 3. Max of circular & normal sum
     * @param arr
     * @return
     */
    public static int maxSumCircularSubArray(int[] arr) {
       int maxNormalSum = maxSumSubArray(arr);
       if (maxNormalSum < 0) {
           return maxNormalSum;
        }
       int fullSum = 0;
       for(int i = 0; i < arr.length; i++) {
           fullSum += arr[i];
       }
       int maxCircularSubArraySum = fullSum - minSumSubArray(arr);
       return Math.max(maxNormalSum, maxCircularSubArraySum);
    }

    public static int maxEvenOddArray(int[] arr) {
        int res = 1;
        int maxArray = 1;
        int state = arr[0] % 2;
        for(int i = 1; i < arr.length; i++) {
            System.out.println("state - " + state);
            if(arr[i] % 2 != state){
                maxArray++;
                res = Math.max(res, maxArray);
            } else {
                maxArray = 1;
            }
            state = arr[i] % 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestIndex(new int[]{}));
        System.out.println(secondLargestIndex(new int[]{1, 2, 4, 3}));
        reverseArray(new int[]{4, 2, 3, 4});
        System.out.println();
        moveZeroes(new int[]{0, 1, 0, 3, 0});
        System.out.println();
        System.out.println(maxDiff(new int[] {1, 2, 3, 4}));
        freqSortedArray(new int[] {10, 10, 10, 22, 22, 24, 24, 24, 24, 24, 24, 199});
        System.out.println(maxProfits(new int[] {1, 5, 4, 12 , 15}));
        System.out.println(trappingRainWater(new int[] {3, 0, 1, 2, 5}));
        System.out.println(trappingRainWater(new int[] {5, 0, 6, 2, 3}));
        System.out.println(maxConsecutiveNum(new int[] {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1}, 1));
        System.out.println(betBalance("WLWLLWLLWWLWWW"));
        frequencyCount(new int[] {2, 3, 2, 3, 5}, 5, 5);
        System.out.println(maxSumSubArray(new int[] {-3, 8, -2, 4, -5, 6}));
        System.out.println(maxEvenOddArray(new int[] {7, 10, 13, 14}));
        System.out.println(maxEvenOddArray(new int[] {10, 12, 16, 14}));
        System.out.println(maxEvenOddArray(new int[]  {7, 10, 12, 14}));
        System.out.println(maxEvenOddArray(new int[] {5, 10, 20, 6, 3, 8}));
    }
}
