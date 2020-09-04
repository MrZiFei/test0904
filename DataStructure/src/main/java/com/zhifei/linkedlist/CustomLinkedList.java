package com.zhifei.linkedlist;

public class CustomLinkedList {
    private HeroNode head = new HeroNode(0, "");

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void addByNo(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp.next != null) {
            if (temp.next.no > node.no) {
                node.next = temp.next.next;
                temp.next = node;
            } else if (temp.next.no == node.no) {
                throw new RuntimeException("元素已存在");
            }
            temp = temp.next;
        }
    }

    public void delNode(int no){
        HeroNode temp = head;
        while(temp.next!=null){
            if(temp.next.no == no){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("链表：head->");

        for (HeroNode cur = head.next;cur!=null;cur=cur.next){
            sb.append(cur.name + "->");
        }
        return sb.append("NULL").toString();
    }

}

class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public String toString() {
        return "[no: + " + no + " name: " + name + " ]";
    }
}

class TestHeroNode {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        HeroNode h1 = new HeroNode(1, "宋江");
        HeroNode h2 = new HeroNode(2, "卢俊义");
        HeroNode h3 = new HeroNode(3, "吴勇");
        HeroNode h4 = new HeroNode(4, "不知道");
        HeroNode h6 = new HeroNode(6, "林冲");
        linkedList.add(h1);
        linkedList.add(h2);
        linkedList.add(h3);
        linkedList.add(h4);
        linkedList.add(h6);
//        linkedList.add(h1);
        System.out.println(linkedList);
        linkedList.delNode(3);
//        linkedList.addByNo(new HeroNode(5, "吴勇"));
        System.out.println(linkedList);
    }
}