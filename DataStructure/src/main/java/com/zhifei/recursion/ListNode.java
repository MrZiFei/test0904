package com.zhifei.recursion;

@SuppressWarnings("all")
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("linkedList: head->");
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}

