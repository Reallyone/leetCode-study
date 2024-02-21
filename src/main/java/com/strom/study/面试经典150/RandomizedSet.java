package com.strom.study.面试经典150;

import java.util.*;

public class RandomizedSet {

    /**
     * 实现RandomizedSet 类：
     * <p>
     * RandomizedSet() 初始化 RandomizedSet 对象
     * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
     * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
     * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    List<Integer> list = new ArrayList();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        // 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }


    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * <p>
     * 「快乐数」 定义为：
     * <p>
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *k
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        return true;
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean param_1 = randomizedSet.insert(2);
        boolean param_2 = randomizedSet.remove(2);
        int param_3 = randomizedSet.getRandom();
        System.out.println(param_3);
    }


}
