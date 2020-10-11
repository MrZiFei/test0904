package com.zhifei.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    /*
            0.1.2.3.4.5.6
            8,5,6,3,4,7,2

        6-5 8,5,6,3,4,2,7   i=6 j = 5; j >=0 ; j--
        6-4 8,5,6,3,4,2,7
        6-3 8,5,6,3,4,2,7
        6-2 8,5,6,3,4,2,7
        6-1 8,5,6,3,4,2,7
        6-0 7,5,6,3,4,2,8

        5-4 7,5,6,3,2,4,8
        5-3 7,5,6,3,2,4,8   i=5 j = 4; j >=0 ;j--
        5-2 7,5,4,3,2,6,8
        5-1 7,5,4,3,2,6,8
        5-0 6,5,4,3,2,7,8

        4-3 6,5,4,2,3,7,8
        4-2 6,5,3,2,4,7,8   i=4 j=3 j >= 0;j--
        4-1 6,4,3,2,5,7,8
        4-0 5,4,3,2,6,7,8

        3-2 5,4,2,3,6,7,8
        3-1 5,3,2,4,6,7,8
        3-0 4,3,2,5,6,7,8

        2-1 4,2,3,5,6,7,8
        2-0 3,2,4,5,6,7,8

        1-0 2,3,4,5,6,7,8

     */

    public static <E extends Comparable<E>> void selectionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * @param arr   需要排序的部分(块)
     * @param start i从哪里开始寻找
     * @param end   j从哪里开始寻找
     * @param <E>
     */
    public static <E extends Comparable<E>> void quickSort(E[] arr, int start, int end) {
        if(start >= end){
            return;
        }
        int i = start;
        int j = end;
        E value = arr[start];
        while (i < j) {
            while (i < j && arr[j].compareTo(value) >= 0) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i].compareTo(value) <= 0) {
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = value;

        quickSort(arr,start,i-1);
        quickSort(arr,j+1,end);

    }

    public static <E extends Comparable<E>> void insertionSort2(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }

        }
    }

    private static Integer[] generateArray(int n){
        Random r = new Random();
        int i = r.nextInt(n);
        Integer[] arr = new Integer[n];
        for (int j = 0; j < n; j++) {
            arr[j] = r.nextInt(i);
        }
        return arr;
    }

    public static void main(String[] args) {

//        Student[] stus = {
//                new Student("张三", 99),
//                new Student("小红", 109),
//                new Student("蓝猫", 76),
//                new Student("淘气", 77),
//                new Student("虹猫", 69)
//        };
//
//        selectionSort(stus);
//
//        System.out.println(Arrays.toString(stus));
//
//        Integer[] nums = {4, 3, 5, 6, 1, 9, 2, 5, 7, 8};
//
//        selectionSort(nums);
//
//        System.out.println(Arrays.toString(nums));
//
//        System.out.println("------------------------------");
//
//        Student[] stus2 = {
//                new Student("张三", 99),
//                new Student("小红", 109),
//                new Student("蓝猫", 76),
//                new Student("淘气", 77),
//                new Student("虹猫", 69)
//        };
//
//        Integer[] nums2 = {4, 3, 5, 6, 1, 9, 2, 5, 7, 8};
//
//        bubbleSort(stus2);
//
//        bubbleSort(nums2);
//
//        System.out.println(Arrays.toString(stus2));
//        System.out.println(Arrays.toString(nums2));

//        Student[] stus3 = {
//                new Student("张三", 99),
//                new Student("小红", 109),
//                new Student("蓝猫", 76),
//                new Student("淘气", 77),
//                new Student("虹猫", 69)
//        };
//        quickSort(stus3,0, stus3.length - 1);
//        System.out.println(Arrays.toString(stus3));
//        Integer[] nums3 = {4, 3, 5, 6, 1, 9, 2, 5, 7, 8};
//        quickSort(nums3,0, nums3.length - 1);
//        System.out.println(Arrays.toString(nums3));
//
        Integer[] array = generateArray(100);
        Integer[] array2 = Arrays.copyOf(array,array.length);
        Integer[] array3 = Arrays.copyOf(array,array.length);


        long start = System.nanoTime();

        quickSort(array,0, array.length - 1);

        long end = System.nanoTime();

        System.out.println("快速排序花费时间：" + (end - start)/1e9 + "s");

        long start1 = System.nanoTime();

        bubbleSort(array2);

        long end1 = System.nanoTime();

        System.out.println("冒泡排序花费时间：" + (end1 - start1)/1e9 + "s");

        long start2 = System.nanoTime();

        insertionSort(array3);

        long end2 = System.nanoTime();

        System.out.println("插入排序花费时间：" + (end2 - start2)/1e9 + "s");

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));

    }


}
