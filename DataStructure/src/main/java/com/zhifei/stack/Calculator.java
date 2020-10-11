package com.zhifei.stack;

public class Calculator {


}

class ArrayStack2 {

    int[] arr;
    int top;

    public ArrayStack2() {
        this(10);
    }

    public ArrayStack2(int size) {
        arr = new int[size];
        top = -1;
    }

    public boolean full() {
        return top == arr.length - 1;
    }

    public void push(int e) {
        if (full()) {
            throw new RuntimeException("栈已满");
        }

        arr[++top] = e;
    }

    public int pop() {
        if (empty()) {
            throw new RuntimeException("栈没有元素");
        }
        return arr[top--];
    }

    private boolean empty() {
        return top == -1;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder("stack : head [");
        for (int i = top; i > -1; i--) {
            if (i != 0)
                sb.append(arr[i] + ",");
            else
                sb.append(arr[i] + "] bottom");
        }
        return sb.toString();
    }

}
