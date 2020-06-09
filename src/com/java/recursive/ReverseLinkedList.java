package com.java.recursive;

public class ReverseLinkedList {

    public static class ListNode {
        int val;

        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void printLinkedList(ListNode curNode) {
        System.out.print("[");
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.print("]\n");
    }

    public static ListNode reverseLinkedList(ListNode curNode) {
        if (curNode == null || curNode.next == null) {
            return curNode;
        }
        ListNode nextNode = curNode.next;
        ListNode preNode = null;
        while (curNode.next != null) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            nextNode = curNode.next;
        }
        curNode.next = preNode;
        return curNode;
    }

    public static ListNode recursiveReverseLinkedList(ListNode curNode) {
        if (curNode == null || curNode.next == null) {
            return curNode;
        }

        ListNode nowNode = recursiveReverseLinkedList(curNode.next);
        curNode.next.next = curNode;
        curNode.next = null;
        return nowNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        printLinkedList(listNode1);

        ListNode listNode = recursiveReverseLinkedList(listNode1);

        printLinkedList(listNode);
    }
}
