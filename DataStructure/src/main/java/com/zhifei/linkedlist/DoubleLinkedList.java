package com.zhifei.linkedlist;

public class DoubleLinkedList<E> {
    private class Node{
        private E e;
        private Node prev;
        private Node next;
        public Node(E e,Node prev,Node next){
            this.e =e;
            this.prev =prev;
            this.next = next;
        }

        public Node(E e){
            this.e =e;
        }

        public Node(){

        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head;
    private int size;

    public DoubleLinkedList(){
        head = new Node();
    }

    public void add(E e){
        Node temp = head;
        Node node = new Node(e);
        while (true){
            if(temp.next == null){
                break;
            }else {
                temp = temp.next;
            }
        }
        temp.next = node;
        node.prev = temp;
    }

    public void delete(E e){
        Node temp = head.next;
        while (temp != null){
            if(temp.e == e){
                temp.prev.next = temp.next;
                if(temp.next != null)
                    temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        temp =null;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LinkedList:head->"));
        Node temp = head.next;
        while(temp != null){
            sb.append(temp + "->");
            temp = temp.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        linkedList.delete(2);
        System.out.println(linkedList);
        linkedList.delete(3);
        System.out.println(linkedList);linkedList.delete(1);
        System.out.println(linkedList);
    }


}
