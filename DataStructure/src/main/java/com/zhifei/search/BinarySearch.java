package com.zhifei.search;

import java.util.Arrays;

public class BinarySearch {

    public static int search(int[] arr, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        int value = arr[middle];

        if (num > value) {
            return search(arr, middle + 1, end, num);
        } else if (num < value) {
            return search(arr, start, middle - 1, num);
        } else {
            return middle;
        }

    }

    public static int[] generateOrderedArray(int num){
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int linearSearch(int[] arr,int n){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = generateOrderedArray(10000000);
        long start = System.nanoTime();
        System.out.println(search(arr, 0, arr.length - 1, 9999999));
        long end = System.nanoTime();

        System.out.println((end - start) + "s");

        long start2 = System.nanoTime();
        System.out.println(linearSearch(arr, 9999999));
        long end2 = System.nanoTime();

        System.out.println((end2-start2) + "s");

    }

}
