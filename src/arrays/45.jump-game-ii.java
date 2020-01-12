/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 *
 * https://leetcode-cn.com/problems/jump-game-ii/description/
 *
 * algorithms
 * Hard (31.00%)
 * Total Accepted:    25.9K
 * Total Submissions: 79.4K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 
 * 
 * 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 使用双指针方法，每次计算可以覆盖的最大最小范围
 */
class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        //表示每一步可以覆盖的最大最小范围
        int start = 0, end = 0;
        int step = 0;
        while (end < len - 1){
            step++;
            int iEnd = end, lastEnd = end;
            for (int i = start; i <= iEnd && end < len - 1; ++i){
                if (end < nums[i] + i){
                    end = nums[i] + i;
                }
            }
            start = lastEnd + 1;
        }
        return step;
    }
}
