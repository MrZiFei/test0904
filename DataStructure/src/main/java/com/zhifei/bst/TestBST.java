package com.zhifei.bst;

public class TestBST {

    public static void main(String[] args) throws Exception {
        BST bst = new BST();
        int[] arr = {5,3,6,8,4,2};
        for (int i : arr) {
            bst.add(i);
        }

        bst.preOrder();
        System.out.println();
//        bst.levelOrder();
//
//        System.out.println("最小值:" + bst.minimum());
//        System.out.println("最大值:" + bst.maximum());
//
//        System.out.println("删除的最小值：" + bst.removeMin());
//
//        bst.preOrder();
//
////        System.out.println("删除的最大值：" + bst.removeMax());

        bst.remove(6);

        bst.preOrder();


    }

}
