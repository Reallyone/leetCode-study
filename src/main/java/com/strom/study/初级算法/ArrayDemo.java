package com.strom.study.初级算法;

public class ArrayDemo {

    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1;
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[index - 1]) {
                continue;
            }
            nums[index] = nums[i];
            index++;
            count++;
        }
        return count;

    }

    /**
     * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
     * <p>
     * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
     * <p>
     * 返回 你能获得的 最大 利润。
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     * 总利润为 4 。
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * @param prices
     */
    public static int maxProfit(int[] prices) {
        if (prices ==null || prices.length ==0){
            return 0;
        }
        int sum = 0 ;
        for (int i = 1; i < prices.length; i++) {
            System.out.println(prices[i] +"--"+prices[i-1] +"---"+sum);
            if (prices[i] > prices[i-1]){
                sum  =sum + (prices[i]-prices[i-1]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }


}
