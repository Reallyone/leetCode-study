package com.strom.study.面试题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class let_node_demo {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
     * <p>
     * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
     * <p>
     * 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 编写一个函数，检查输入的链表是否是回文的。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> listNodeStack = new Stack<>();
        ListNode newNode = head;
        while (newNode != null) {
            listNodeStack.add(newNode.val);
            newNode = newNode.next;
        }

        while (head != null) {
            if (head.val != listNodeStack.pop()) {
                return false;
            } else {
                head = head.next;
            }
        }

        return true;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode head = headA;
        while (head != null) {
            nodeSet.add(head);
            head = head.next;
        }
        head = headB;
        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }


}
