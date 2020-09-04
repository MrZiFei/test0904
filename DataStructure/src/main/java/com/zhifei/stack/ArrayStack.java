package com.zhifei.stack;

public class ArrayStack<E> implements Stack<E>{

    private E[] stack;
    private int size;


    public ArrayStack(int capacity){
        stack = (E[])new Object[capacity];
        size = 0;
    }

    public ArrayStack(){
        this(5);
    }

    @Override
    public void push(E e) {
        if(size == stack.length){
            throw new RuntimeException("栈已满");
        }
        stack[size] = e;
        size++;
    }

    @Override
    public E pop() {
        if(empty()){
            throw new RuntimeException("栈是空的");
        }
        E[] e = (E[])new Object[5];
        size--;
        E ele = stack[size];
        for (int i = 0; i < size; i++) {
            e[i] = stack[i];
        }
        stack = e;
        return ele;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public E peek() {
        return stack[size-1];
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("ArrayStack:  size-->" + size + "\r\n");
        sb.append("ArrayStack:  capacity-->" + stack.length + "\r\n");
        sb.append("[");
        for (int i = 0;i < stack.length; i++){
            sb.append(stack[i]);
            if(i != stack.length-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
