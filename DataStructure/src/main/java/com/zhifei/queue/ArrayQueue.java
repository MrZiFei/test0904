package com.zhifei.queue;

import java.io.File;

public class ArrayQueue {

    private int maxSize;//最大容量
    private int front;//队首指针
    private int rear;//队尾指针
    private int[] data;//模拟队列的数组

    public ArrayQueue(int capacity){
        maxSize = capacity;
        front = -1;
        rear = -1;
        data = new int[capacity];
    }

    public ArrayQueue(){
        this(5);
    }
    //队列是否是空的
    public boolean isEmpty(){
        return front == rear;
    }
    //队列是否是满的
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //添加一个元素
    public void add(int e){
        if(isFull()){
            throw new RuntimeException("队列已满，不可再添加");
        }
        rear++;
        data[rear] = e;
    }
    //取出一个元素
    public void remove(){
        if(isEmpty()){
            throw new RuntimeException("队列是空的，没有元素可以取出");
        }
        front++;
    }
    //遍历队列
    public void print(){
        for (int i = front+1; i < rear+1 ; i++) {
            System.out.printf("%d\t",data[i]);
        }
    }
    //查看队首的元素
    public int peek(){
        return data[front+1];
    }

    public static void main(String[] args) {
        File src = new File("G:\\学习资料\\编程\\B站最好的Spring讲解");

        File[] files = src.listFiles();
        for (File file : files) {

            String name = file.getName();

            if(name.startsWith(")")){
                String filename = name.substring(1);

                file.renameTo(new File("G:\\学习资料\\编程\\B站最好的Spring讲解\\" + filename));
            }
        }


    }



}
