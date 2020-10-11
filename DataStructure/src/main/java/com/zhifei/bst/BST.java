package com.zhifei.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private class Node{
        E e;
        Node left,right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
    private int size;
    private Node root;

    public void add(E e){
        root = add(root, e);
    }
    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }
        //如果传进来的子树根节点不为空，就判断子树根节点的元素与要添加的元素是大于还是小于的关系
        //如果要添加的元素小于子树根节点的元素，说明要放在左子树的某个节点，于是先看子树根节点的左孩子是不是空
        //所以将左孩子作为新的子树根节点再判断新的子树根节点是不是空，这样的操作就是函数本身在做的，所以递归调用自己即可
        //于是又有了新的子树根节点的非空判断，如果左孩子是空，就直接返回新节点给左孩子，如果不是空接着往下判断左孩子的左孩子是不是空
        //直到判断到空了，就添加进去了。
        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        //首次查询的是根节点
        return contains(root, e);
    }
    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.equals(node.e)){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left,depth + 1,res);
        generateBSTString(node.right,depth + 1,res);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //首先保存栈顶的元素
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return ;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    public E minimum() throws Exception{
        if(size == 0){
            throw new Exception("二分搜索树中没有元素");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() throws Exception {
        if(size == 0){
            throw new Exception("二分搜索树中没有元素");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin() throws Exception {
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() throws Exception{
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root,e);
    }

    private Node remove(Node node, E e) {
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right,e);
            return node;
        }else{ // e == node.e
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node leftMax = maximum(node.left);
            leftMax.left = removeMax(node.left);
            leftMax.right = node.right;
            node.left = node.right = null;
            return leftMax;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
}
