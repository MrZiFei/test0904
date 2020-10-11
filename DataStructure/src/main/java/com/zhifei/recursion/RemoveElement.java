package com.zhifei.recursion;

public class RemoveElement {

    public ListNode removeElements(ListNode head, int val){
        if(head == null){
            return null;
        }
        ListNode result = removeElements(head.next,val);
        if(head.val == val){
            return result;
        }else{
            head.next = result;
            return head;
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,2,3,6,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode node = new RemoveElement().removeElements(head, 6);
        System.out.println(node);
    }

}
