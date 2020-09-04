package com.zhifei.queue;

public class TestArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.add(3);
        queue.add(2);
        queue.add(5);
        queue.print();
        System.out.println("队头元素："+queue.peek());
        System.out.println("\r\n------");
        queue.remove();
        queue.print();
        System.out.println("队头元素："+queue.peek());
    }

}
