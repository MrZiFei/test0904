package com.zhifei.stack;

public class LinkedListStack<E> implements Stack<E> {

    private class Node {
        E e;
        Node next;

        public Node(E e) {
            this.e = e;
        }

        public String toString() {
            return e.toString();
        }
    }

    private Node bottom;
    private Node top;
    private int size;

    @Override
    public void push(E e) {
        //是否第一次添加
        if(top == null){
            top = new Node(e);
            bottom = top;
        }else{
            top.next = new Node(e);
            top = top.next;
        }
        size++;
    }

    @Override
    public E pop() {
        Node prev = bottom;
        while(prev.next!=top){
            prev = prev.next;
        }
        E e = top.e;
        top = prev;
        prev.next = null;
        return e;
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer rest = new StringBuffer();
        rest.append("stack : bottom <-");
        for (Node curr = bottom;curr != null;curr = curr.next){
            rest.append(curr + "<-");
        }
        return rest.append(" top").toString();
    }

}

class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(stack.pop() + "弹出栈");
        System.out.println(stack);
        System.out.println(stack.pop() + "弹出栈");
        System.out.println(stack);
        System.out.println(stack.pop() + "弹出栈");
        System.out.println(stack);
        System.out.println(stack.pop() + "弹出栈");
        System.out.println(stack);
        System.out.println(stack.pop() + "弹出栈");
        System.out.println(stack);
    }
}