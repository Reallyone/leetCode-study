package com.strom.study.初级算法;

import java.util.HashMap;
import java.util.Map;

public class numberDemo {


    /**
     * 多数元素
     * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * age :nums = [3,2,3] 输出：3
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> temMap = new HashMap<>();
        for (int num : nums) {
            if (!temMap.containsKey(num)) {
                temMap.put(num, 1);
            } else {
                temMap.put(num, temMap.get(num) + 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : temMap.entrySet()) {

            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

}
