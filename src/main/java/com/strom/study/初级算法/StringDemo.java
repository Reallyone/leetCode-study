package com.strom.study.初级算法;

public class StringDemo {

  /**
   * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   * 
   * @param s
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    int[] last = new int[128];
    int n = s.length();
    int res = 0;
    int start = 0;
    for (int i = 0; i < n; i++) {
      //表示ASCII 的值
      int index = s.charAt(i);
    
      start = Math.max(start, last[index]);
      res = Math.max(res, i - start + 1);
      System.out.println(index +"--"+ last[index] +"--"+start +"--"+res);
      last[index] = i + 1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abb"));
  }
}
