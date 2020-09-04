package com.zhifei.stack;

public interface Stack<E> {

    void push(E e);

    E pop();

    boolean empty();

    E peek();

    int getSize();

}
