package com.strom.study.初级算法;

import java.util.Stack;

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
            System.out.println(index + "--" + last[index] + "--" + start + "--" + res);
            last[index] = i + 1;
        }
        return res;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Stack<Character> stack = new Stack();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.empty() || c != stack.pop())
                return false;
        }
        return stack.empty() ? true : false;
    }

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    maxLen = arr[i][j];
                    maxEnd = i; //以 i 位置结尾的字符
                }

            }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    public static void main(String[] args) {
        System.out.println(isValid("()}"));
    }
}
