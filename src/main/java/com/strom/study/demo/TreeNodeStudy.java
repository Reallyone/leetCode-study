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


    public static void main(String[] args) {

    }
}
