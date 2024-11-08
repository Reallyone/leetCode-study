package com.strom.study.初级算法;

import java.util.*;

public class ArrayDemo {

    /**
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
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
     * 买卖股票的最佳时机2
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
     *
     * @param prices
     */
    public static int maxProfit02(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            System.out.println(prices[i] + "--" + prices[i - 1] + "---" + sum);
            if (prices[i] > prices[i - 1]) {
                sum = sum + (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     * <p>
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn8fsh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public static int maxProfit01(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 记录最大的值
        int max = 0;
        // 记录访问过的最小值
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 比较两个数中较小的值
            min = Math.min(min, prices[i]);
            // 比较两个数中最大的值
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * @param nums
     * @param k
     * @return
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int newNums[] = new int[length];
        for (int i = 0; i < length; i++) {
            newNums[i] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = newNums[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     * nums = [1,2,3,4] false
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }

        if (temp.size() != nums.length) {
            return true;
        }

        return false;
    }

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        /*
         * Arrays.sort(nums);
         * int sing = 0;
         * for (int i = 0; i < nums.length; i++) {
         * if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
         * i++;
         * } else {
         * sing = i;
         * }
         * }
         * return nums[sing];
         */

        Set<Integer> tempSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!tempSet.add(nums[i])) {
                tempSet.remove(nums[i]);
            }
        }
        return (int) tempSet.toArray()[0];

    }

    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
     * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     * nums1 = [1,2,2,1], nums2 = [2,2] 输出 [2,2]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            // 每次操作后统计出现的次数
            tempMap.put(nums1[i], tempMap.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (tempMap.getOrDefault(nums2[i], 0) > 0) {
                arrayList.add(nums2[i]);
                // 出现后就删除一次次数
                tempMap.put(nums2[i], tempMap.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * digits = [1,2,3] 输出：[1,2,4]
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            System.out.println(digits[i]);
            if (digits[i] != 9) {
                // 如果数组当前元素不等于9，直接加1
                // 然后直接返回
                digits[i]++;
                return digits;
            } else {
                // 如果数组当前元素等于9，那么加1之后
                // 肯定会变为0，我们先让他变为0
                digits[i] = 0;
            }
        }
        /**
         * 如果都为9 --就进一位
         */
        int temp[] = new int[length + 1];
        temp[0] = 1;
        return temp;
    }

    /**
     * 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * nums = [0,1,0,3,12] [1,3,12,0,0]
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        /*
         * for (int i = 0; i < nums.length; i++) {
         * //如果不为0 往前移动
         * if (nums[i] != 0) {
         * //将前面的0赋值，将nums[i] =0
         * nums[i - index] = nums[i];
         * nums[i] = 0;
         * } else {
         * index++;
         * }
         * }
         */

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }

        for (; i < m; ) {
            temp[index++] = nums1[i++];
        }

        for (; j < n; ) {
            temp[index++] = nums2[j++];
        }

        // 再把数组temp中的值赋给nums1
        for (int k = 0; k < m + n; k++) {
            nums1[k] = temp[k];
        }
    }

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int cur = nums[0];
        int max = cur;
        for (int i = 1; i < length; i++) {
            cur = Math.max(cur, 0) + nums[i];
            // 记录最大值
            max = Math.max(max, cur);
            System.out.println(cur + "--" + max);
        }
        return max;
    }

    /*
     * 打家劫舍
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     */
    public static int rob(int[] nums) {
        // 边界条件判断
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        int dp0 = 0;// 第1家没偷
        int dp1 = nums[0];// 第1家偷了
        // 从第2个开始判断
        for (int i = 1; i < length; i++) {
            // 防止dp0被修改之后对下面运算造成影响，这里
            // 使用一个临时变量temp先把结果存起来，计算完
            // 之后再赋值给dp0.
            int temp = Math.max(dp0, dp1);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        // 最后取最大值即可
        return Math.max(dp0, dp1);
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(twoSum(nums1, 4)));
    }

}
