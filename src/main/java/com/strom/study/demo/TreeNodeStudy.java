package com.strom.study.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNodeStudy {
    public List<Integer> inorderTraversal(SimpleQuestions.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<SimpleQuestions.TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public boolean isSymmetric(SimpleQuestions.TreeNode root) {
        return f(root, root);
    }

    // 函数f，用来判断两个节点是否为镜像对称
    public boolean f(SimpleQuestions.TreeNode left, SimpleQuestions.TreeNode right) {
        // 两节点为NULL，镜像对称，返回true
        if (left == null && right == null) return true;
        // 其中一个为NULL，不镜像对称，返回false
        if (left == null || right == null) return false;
        // 两节点不相等，不镜像对称，返回false
        if (left.val != right.val) return false;
        // 两节点镜像对称，起决定作用的，只剩下两节点的左右节点是否镜像对称，如果也对称，则返回true
        return (left.val == left.val) && f(left.left, right.right) && f(left.right, right.left);
    }

    public int maxDepth(SimpleQuestions.TreeNode root) {
        int max = 0;
        int leftMax = 0;
        int rightMax = 0;
        if (root != null) {
            max++;
            leftMax = maxDepth(root.left);
            rightMax = maxDepth(root.right);
            max += leftMax >= rightMax ? leftMax : rightMax;
        }
        return max;
    }

    /**
     * 杨辉三角
     * 第n行有n个数字
     * 每一行的开始和结尾数字都为1.
     * 第n+1行的第i个数字等于第n行的i-1个数字加上第n行的i个数字。
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            System.out.println(i);
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
                subList.add(arr[i][j]);
            }
            list.add(subList);
        }
        return list;
    }

    /**
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> numbers = new ArrayList<>(rowIndex + 1);
        long cur = 1;

        for (int i = 0; i <= rowIndex; i++) {
            numbers.add((int) cur);
            System.out.println(cur + "==" + (rowIndex - i));
            cur = cur * (rowIndex - i) / (i + 1);
            System.out.println("----" + cur);
        }
        return numbers;
    }


    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
}
