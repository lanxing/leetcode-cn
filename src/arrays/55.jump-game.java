/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 *
 * https://leetcode-cn.com/problems/jump-game/description/
 *
 * algorithms
 * Medium (33.83%)
 * Total Accepted:    14K
 * Total Submissions: 40.7K
 * Testcase Example:  '[2,3,1,1,4]'
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * 
 * 类似于45，确定没跳一次可以达到的最大范围，然后搜索min和max之间可以跳的最大值
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1){
            return true;
        }
        int maxLen = nums.length - 1;
        int min = 0, max = 0;

        while (min <= max){
            int tmpMax = max;
            for (int i = min; i <= max; ++i){
                int tmp = nums[i] + i;
                if (tmp >= maxLen){
                    return true;
                }
                max = Math.max(max, tmp);
            }
            if (tmpMax == max){
                return false;
            }
            min = tmpMax;
        }
        return false;
    }
}
