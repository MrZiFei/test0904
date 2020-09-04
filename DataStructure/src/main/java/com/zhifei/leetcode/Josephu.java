package com.zhifei.leetcode;

public class Josephu {
    private class Node {
        int no;
        Node next;

        public Node(int no) {
            this.no = no;
        }

        public String toString() {
            return "" + no;
        }
    }

    private Node first;
    private int size;

    public void add(int nums) {
        if (nums < 1) {
            throw new IllegalArgumentException("请输入大于1的数字");
        }
        Node curr = null;
        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.next = first;
                curr = first;
            } else {
                curr.next = node;
                node.next = first;
                curr = node;
            }
            size++;
        }
    }

    public int getSize() {
        return size;
    }


    public void count(int n, int k, int m){
        add(n);
        if(k < 0 || k > n){
            throw new IllegalArgumentException("k不能取在n的范围之外");
        }
        Node curr = first;
        while (curr.next != first) {
            curr = curr.next;
        }
        for (int i = 0; i < k - 1; i++) {
            first = first.next;
            curr = curr.next;
        }
        while (curr != first){
            for (int i = 0; i < m - 1; i++) {
                first = first.next;
                curr = curr.next;
            }
            System.out.println(first.no + "出队列");
            first = first.next;
            curr.next = first;
        }
        System.out.println("最后剩下的是" + first.no);
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("LinkedList : head->");
        Node curr = first;
        while (true) {
            ret.append(curr.no + "->");
            if(curr.next == first){
                break;
            }
            curr = curr.next;
        }
        ret.append("NULL");
        return ret.toString();
    }
}

class TestJo {
    public static void main(String[] args) {
        Josephu j = new Josephu();
        j.count(10,1,3);
        System.out.println(j);
    }
}




