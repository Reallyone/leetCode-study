package com.strom.study.初级算法;

public class SourtDemo {

    /**
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本
     * The isBadVersion API is defined in the parent class VersionControl.
     * boolean isBadVersion(int version)
     * 
     */
    public static boolean isBadVersion(int version) {
        return true;
    }

    public static int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while (first < last) {
            int mid = (first + last) >>> 1;
            if (!isBadVersion(mid)) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public static int climbStairs(int n) {
        if(n<=1) return 1;
        int[] res =new int[n+1];
        res[1] =1;
        res[2]=2;
        for (int i = 3; i <= n; i++) {
            res[i] = res[i-1] +res[i-2];
        }
        return res[n];
    }



    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }

}