package com.strom.study.面试题;

public class Basic {

  public static void main(String[] args) {
    // i++ 和 ++i 的区别
    int i = 3;
    int y = 10;
    int result = (i++) + (++y) + y;
    System.out.println(result);
  }

}
