package com.zhifei.array;

public class Main {

    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>(6);
        for (int i = 0; i < 20; i++) {
            arr.add(i,i);
        }
        System.out.println(arr);

        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        arr.removeLast();
        System.out.println(arr);

    }

}
