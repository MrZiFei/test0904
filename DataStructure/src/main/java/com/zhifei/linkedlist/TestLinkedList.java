package com.zhifei.linkedlist;

public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, i);
        }
        System.out.println(linkedList);
        System.out.println("------------");
//        LinkedList<Integer> linkedListB = linkedList.reverseLinkedList();
//        System.out.println(linkedListB);
//        linkedList.add(5, 666);
//        System.out.println(linkedList);
//        System.out.println(linkedList.contains(3));
//        Integer remove = linkedList.remove(5);
//        System.out.println("删除的元素" + remove);
//        System.out.println(linkedList);

//        System.out.println("倒数第6个元素为：" + linkedList.getFromLast(1));


    }

}
