package com.zhifei.linkedlist;

public class TestLinkedQueue {

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            linkedListQueue.enqueue(i + 1);
        }

        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.dequeue() + "出队列");
        System.out.println(linkedListQueue);
        linkedListQueue.enqueue(6);
        System.out.println(linkedListQueue);
        System.out.println(linkedListQueue.dequeue() + "出队列");
        System.out.println(linkedListQueue);
    }

}
