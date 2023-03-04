package com.strom.study.初级算法;

public class NodeDemo {

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
    // 然后让前一个结点的next指向要删除节点的next
    pre.next = pre.next.next;
    return head;
  }

  /**
   * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
   * 请你将两个数相加，并以相同形式返回一个表示和的链表。
   * 
   */
  public static class ListNode_addTwoNumbers {
    int val;
    ListNode_addTwoNumbers next;

    ListNode_addTwoNumbers() {
    }

    ListNode_addTwoNumbers(int val) {
      this.val = val;
    }

    ListNode_addTwoNumbers(int val, ListNode_addTwoNumbers next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode_addTwoNumbers addTwoNumbers(ListNode_addTwoNumbers l1, ListNode_addTwoNumbers l2) {
    ListNode_addTwoNumbers prev = new ListNode_addTwoNumbers(0);
    // 定义一个新的指针， 用来存储两位大于0 的时候
    int carry = 0;
    // 定义一个可移动的指针，用来指向存储两个数之和的位置
    ListNode_addTwoNumbers cur = prev;
    // 当l1 不等于null或l2 不等于空时，就进入循环
    while (l1 != null || l2 != null) {
      // 如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
      int x = l1 != null ? l1.val : 0;
      // 如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
      int y = l2 != null ? l2.val : 0;
      // 将两个链表的值，进行相加，并加上进位数
      int sum = x + y + carry;
      
      // 计算进位数
      carry = sum / 10;
      // 计算两个数的和，此时排除超过10的请况（大于10，取余数）
      sum = sum % 10;
      // 将求和数赋值给新链表的节点，
      // 注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
      // 所以这个时候要创一个新的节点，将值赋予节点
      cur.next = new ListNode_addTwoNumbers(sum);
      // 将新链表的节点后移
      cur = cur.next;
      // 当链表l1不等于null的时候，将l1 的节点后移
      if (l1 != null) {
        l1 = l1.next;
      }
      // 当链表l2 不等于null的时候，将l2的节点后移
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    // 如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
    // 两数相加最多小于20，所以的的值最大只能时1
    if (carry == 1) {
      cur.next = new ListNode_addTwoNumbers(carry);
    }
    // 返回链表的头节点
    return prev.next;
  }

  public static void main(String[] args) {
    ListNode_addTwoNumbers l1 = new ListNode_addTwoNumbers(3);
    l1.next = new ListNode_addTwoNumbers(2);
    l1.next = new ListNode_addTwoNumbers(4);
    l1.next = new ListNode_addTwoNumbers(3);

    ListNode_addTwoNumbers l2 = new ListNode_addTwoNumbers(0);
    l2.next = new ListNode_addTwoNumbers(5);
    l2.next = new ListNode_addTwoNumbers(6);
    l2.next = new ListNode_addTwoNumbers(4);
    System.out.println(addTwoNumbers(l1, l2).next.toString());

  }
}
