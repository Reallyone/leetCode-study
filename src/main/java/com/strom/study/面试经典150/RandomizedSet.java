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
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(index,last);
        list.remove(list.size() - 1);
        map.put(last,index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        boolean param_1 = randomizedSet.insert(2);
        boolean param_2 = randomizedSet.remove(2);
        int param_3 = randomizedSet.getRandom();
        System.out.println(param_3);
    }


}
