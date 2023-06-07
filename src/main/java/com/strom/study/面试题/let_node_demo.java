package com.strom.study.面试题;

import java.util.HashSet;
import java.util.Set;

public class let_node_demo {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     *
     * @param head
     * @return
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> setH = new HashSet<>();
        setH.add(head.val);
        ListNode pos = head;
        while (pos.next != null) {
            ListNode cur = pos.next;
            if (setH.add(cur.val)) {
                pos = pos.next;
            } else {
                pos.next = pos.next.next;
            }
        }
        pos.next = null;
        return head;
    }

    /**
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * 1->2->3->4->5 和 k = 2 输出：4
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        for (int i = 0; i < count - k; i++) {
            head = head.next;
        }

        return head.val;
    }




}
