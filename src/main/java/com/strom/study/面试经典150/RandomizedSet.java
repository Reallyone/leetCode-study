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
     * k
     *
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        int slow = n, fast = squareSum(n);
        System.out.println("1---slow--" + slow + "fast--" + fast);
        while (slow != fast) {
            System.out.println("2---slow--" + slow + "fast--" + fast);
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
            System.out.println("3---slow--" + slow + "fast--" + fast);
        }
        ;
        return slow == 1;
    }


    public static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            System.out.println("squareSum--n:" + n + "--digit:" + digit);
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }


    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }


    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];

        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * @param
     * @return
     */
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) { // 遍历字符串中的每个字符
            switch (c) {
                case '(': // 如果当前字符是左括号
                    stack.push(')'); // 将对应的右括号压入栈中
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default: // 如果当前字符是右括号
                    if (stack.isEmpty() || stack.pop() != c) { // 弹出栈顶元素与当前字符比较，不匹配则返回 false
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 规则定义： 设学生 A 和学生 B 左右相邻，A 在 B 左边；
     * 左规则： 当 ratings
     * B
     * ​
     * >ratings
     * A
     * ​
     * 时，B 的糖比 A 的糖数量多。
     * 右规则： 当 ratings
     * A
     * ​
     * >ratings
     * B
     * ​
     * 时，A 的糖比 B 的糖数量多。
     * 相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
     * <p>
     * 算法流程：
     * <p>
     * 先从左至右遍历学生成绩 ratings，按照以下规则给糖，并记录在 left 中：
     * <p>
     * 先给所有学生 1 颗糖；
     * <p>
     * 若 ratings
     * i
     * ​
     * >ratings
     * i−1
     * ​
     * ，则第 i 名学生糖比第 i−1 名学生多 1 个。
     * <p>
     * 若 ratings
     * i
     * ​
     * <=ratings
     * i−1
     * ​
     * ，则第 i 名学生糖数量不变。（交由从右向左遍历时处理。）
     * <p>
     * 经过此规则分配后，可以保证所有学生糖数量 满足左规则 。
     * 同理，在此规则下从右至左遍历学生成绩并记录在 right 中，可以保证所有学生糖数量 满足右规则 。
     * <p>
     * 最终，取以上 2 轮遍历 left 和 right 对应学生糖果数的 最大值 ，这样则 同时满足左规则和右规则 ，即得到每个同学的最少糖果数量。
     * <p>
     * 复杂度分析：
     * <p>
     * 时间复杂度 O(N) ： 遍历两遍数组即可得到结果；
     * 空间复杂度 O(N) ： 需要借用 left，right 的线性额外空间。
     *
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }
        return count;

    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            // 检查加入当前单词后是否超过 maxWidth
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                // 处理当前行
                if (currentLine.size() == 1) {
                    // 只有一个单词的情况，左对齐即可
                    StringBuilder line = new StringBuilder(currentLine.get(0));
                    while (line.length() < maxWidth) {
                        line.append(" ");
                    }
                    result.add(line.toString());
                } else {
                    // 计算空格数
                    int totalSpaces = maxWidth - currentLength;
                    int spaceBetweenWords = totalSpaces / (currentLine.size() - 1);
                    int extraSpaces = totalSpaces % (currentLine.size() - 1);

                    // 构建当前行
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < currentLine.size(); i++) {
                        line.append(currentLine.get(i));
                        if (i < currentLine.size() - 1) {
                            int spacesToApply = spaceBetweenWords + (i < extraSpaces ? 1 : 0);
                            for (int j = 0; j < spacesToApply; j++) {
                                line.append(" ");
                            }
                        }
                    }
                    result.add(line.toString());
                }

                // 重置当前行
                currentLine.clear();
                currentLine.add(word);
                currentLength = word.length();
            } else {
                // 加入当前单词
                currentLine.add(word);
                currentLength += word.length();
            }
        }

        // 处理最后一行：左对齐，单词间一个空格
        StringBuilder lastLine = new StringBuilder(String.join(" ", currentLine));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }


    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        StringBuffer[] mat = new StringBuffer[r];
        for (int i = 0; i < r; ++i) {
            mat[i] = new StringBuffer();
        }
        for (int i = 0, x = 0, t = r * 2 - 2; i < n; ++i) {
            mat[x].append(s.charAt(i));
            if (i % t < r - 1) {
                ++x;
            } else {
                --x;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row : mat) {
            ans.append(row);
        }
        return ans.toString();
    }

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * <p>
     * 你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 先对数组进行排序，方便后续处理

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 避免重复结果
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++; // 避免重复结果
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--; // 避免重复结果
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {

        RandomizedSet tj = new RandomizedSet();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> justifiedText = tj.fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }


}
