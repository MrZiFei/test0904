package com.zhifei.linkedlist;

public class LinkedList<E> {
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

    public Node virtualNode;
    public int size;

    public LinkedList() {
        virtualNode = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界，不可删除");
        }
        Node prev = virtualNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界，不可插入");
        }
        Node prev = virtualNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界了");
        }
        Node cur = virtualNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引越界了");
        }
        Node cur = virtualNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        for (Node cur = virtualNode.next; cur != null; cur = cur.next) {
            if (cur.e.equals(e))
                return true;
        }
        return false;
    }


    public E getFromLast(int count) {
        Node cur = virtualNode.next;
        for (int i = 0; i < size - count; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public LinkedList<E> reverseLinkedList() {
        LinkedList<E> linkedListB = new LinkedList<>();
        Node cur = virtualNode.next;
        for (int i = 0; i < size; i++) {
            linkedListB.addFirst(cur.e);
            cur = cur.next;
        }
        return linkedListB;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Node cur = virtualNode.next; cur != null; cur = cur.next) {
            ret.append(cur + "->");
        }
        ret.append("NULL");
        return ret.toString();
    }
}
