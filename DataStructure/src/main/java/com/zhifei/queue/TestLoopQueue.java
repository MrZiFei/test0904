package com.zhifei.queue;

public class TestLoopQueue {

    public static void main(String[] args) {
        LoopQueue<Integer> q = new LoopQueue<>(8);
        for (int i = 0; i < 20; i++) {
            q.enqueue(i);
            if(i % 3 == 2) {
                System.out.println(q);
                System.out.println(q.dequeue() + "出队列");
                System.out.println(q);
            }
            System.out.println("----------");
            System.out.println(q);
        }


    }

}
