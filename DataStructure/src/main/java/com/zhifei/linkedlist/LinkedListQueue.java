package com.zhifei.linkedlist;

public class LinkedListQueue<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public String toString() {
            return e.toString();
        }
    }

    public Node head,tail;
    public int size;

    public void enqueue(E e){
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue(){
        if(head == null){
            throw new RuntimeException("队列是空的");
        }
        Node ret = head;
        head = head.next;
        ret.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return ret.e;
    }


    public String toString() {
        StringBuilder ret = new StringBuilder("Queue: head ");
        for (Node cur = head; cur != null; cur = cur.next) {
            ret.append(cur + "->");
        }
        ret.append("NULL  tail");
        return ret.toString();
    }
}
