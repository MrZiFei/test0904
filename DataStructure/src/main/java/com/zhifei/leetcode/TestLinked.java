package com.zhifei.leetcode;

public class TestLinked {
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 */
class Solution {
    public static void deleteNode(ListNode node) {
        ListNode temp = new ListNode(-1);

        for (temp.next = node;temp!=null;temp = temp.next){
            if(temp.val == node.val){
                temp.next = node.next;
                node.next = null;
            }
        }

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6};
        ListNode node = new ListNode(arr);
        System.out.println(node);
//        deleteNode(new ListNode(3));
//        System.out.println(node);
        ListNode listNode = reverseList(node);
        System.out.println(listNode);
    }
}