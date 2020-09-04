package com.zhifei.linkedlist;

public class LinkedListStack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    public void push(E e){
        linkedList.addFirst(e);
    }

    public E pop(){
        return linkedList.removeFirst();
    }

    public E peek(){
        return linkedList.getFirst();
    }

    public boolean empty(){
        return linkedList.getSize() == 0;
    }

    public int getSize(){
        return linkedList.getSize();
    }



}
