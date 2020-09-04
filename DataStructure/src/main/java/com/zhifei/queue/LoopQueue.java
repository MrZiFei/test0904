package com.zhifei.queue;

public class LoopQueue<E> {

    private int size;
    private int front;
    private int rear;
    private E[] data;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity +1];
        rear = 0;
        front = 0;
        size = 0;
    }

    public LoopQueue(){
        this(5);
    }

    public boolean empty(){
        return size == 0;
    }

    public boolean full(){
        return (rear + 1) % data.length == front;
    }

    public void enqueue(E e){
        if(full()){
            resize(getCapacity() * 2);
        }
        data[rear] = e;
        rear = (rear + 1) % data.length;
        size++;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = size;
    }

    public E dequeue(){
        if(empty()) throw new RuntimeException("队列是空的");
        E e = data[front];
        front = (front+1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("Queue: capacity -> %d\t size -> %d",getCapacity(),size));
        ret.append("\nfront[");
        //从队头开始，但是队尾的索引可能会比front小，所以i不能取到rear，rear指向的是空的位置
        for (int i = front; i != rear; i = (i + 1) % data.length) {
            ret.append(data[i]);
            if((i+1)% data.length != rear){
                ret.append(",");
            }
        }
        ret.append("]rear");

        return ret.toString();
    }

    public E peek(){
        return data[front];
    }

}
