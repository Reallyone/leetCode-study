package com.strom.study.面试题;

import java.util.Arrays;

public class let_str_demo {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     */
    public static boolean isUnique(String astr) {
        final char[] chars = astr.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            final char aChar = chars[i];
            if (aChar == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * @param s1
     * @param s2
     * @return
     */
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() !=s2.length()) return  false;
        final char[] chars1 = s1.toCharArray();
        final char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
             if (chars1[i] !=chars2[i]){
                 return  false;
             }
        }
        return  true;
    }

    /**
     * 编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
     *
     * @param S
     * @param length
     * @return
     */
    public static String replaceSpaces(String S, int length) {

        StringBuilder stringBuilder = new StringBuilder();
        //逐渐遍历字符串
        for (int i = 0; i < length; i++) {
            //如果不是空格就加入到StringBuilder中，如果是空格
            //就把"%20"加入到StringBuilder中
            char ch = S.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
    }


}
