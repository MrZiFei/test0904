package com.zhifei.search;

public class DistincSearch {

    public static int search(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9};

        int result = search(arr);

        System.out.println(result);

    }


}
