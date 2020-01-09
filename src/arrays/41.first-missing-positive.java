/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 *
 * https://leetcode-cn.com/problems/first-missing-positive/description/
 *
 * algorithms
 * Hard (35.60%)
 * Total Accepted:    11.2K
 * Total Submissions: 31.7K
 * Testcase Example:  '[1,2,0]'
 *
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 
 * 
 * 示例 3:
 * 
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 
 * 
 * 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 *
 * 思路：调整数组，使数组的第i个位置上的值为i+1
 * 遍历数组，第一个第i位置上的值不是i+1的就为所求的数
 * [3,4,-1,1]
 * 调整后为[1,4,3,-1]
 *
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 1;
        }
        int i = 0;
        while (i < len){
            //第i位置上的值刚好等于i+1
            if (nums[i] - 1 == i){
                ++i;
                continue;
            }
            //对于小于0的值，找不到与其对应的位置，直接跳过
            if (nums[i] - 1 < 0){
                ++i;
                continue;
            }
            //对于大于等于len的，直接跳过
            if (nums[i] - 1 >= len){
                ++i;
                continue;
            }
            //如果不相等，则交换
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }else {
                i++;
            }
        }

        for (i = 0; i < len; ++i){
            if (nums[i] - 1 != i){
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
