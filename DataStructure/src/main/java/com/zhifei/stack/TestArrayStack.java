package com.zhifei.stack;

public class TestArrayStack {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println("----------");

        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        stack.push(6);
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        stack.push(6);
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");

        System.out.println("弹出元素" +stack.pop());
        System.out.println(stack);
        System.out.println("----------");


    }


}
