package com.strom.study.初级算法;

public class NodeDemo {

  /**
   * Definition for singly-linked list.
   */
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

  // 获取节点所在位置，逆序
  public int length(ListNode head) {
    int len = 0;
    while (head != null) {
      len++;
      head = head.next;
    }
    return len;
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode pre = head;
    int last = length(head) - n;
    if (last == 0)
      return head.next;

    for (int i = 0; i < last - 1; i++) {
      pre = pre.next;
    }
    //然后让前一个结点的next指向要删除节点的next
    pre.next = pre.next.next;
    return head;
  }

  public static void main(String[] args) {
    System.out.println("1");
  }
}
