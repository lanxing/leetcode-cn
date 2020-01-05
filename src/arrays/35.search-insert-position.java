/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 *
 * https://leetcode-cn.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.86%)
 * Total Accepted:    38.7K
 * Total Submissions: 89.5K
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 
 * 
 * 示例 3:
 * 
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 
 * 
 * 示例 4:
 * 
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 
 * 
 */
class Solution {
    // 将问题转化为寻找一个数，如果找到则返回其所在位置，
    // 否则寻找一个位置index，使得nums[index] < target && nums[index+1] > target
    public int searchInsert(int[] nums, int target) {
        //先过滤掉一部分特殊情况，方便后边处理
        if (nums.length == 0 || nums[0] > target){
            return 0;
        }
        if (nums[nums.length - 1] < target){
            return nums.length;
        }
        //经过上述两个过滤，就不需要考虑边界情况了
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            int midValue = nums[mid];
            if (midValue == target){
                return mid;
            }
            if (midValue < target){
                if (nums[mid + 1] > target){
                    return mid + 1;
                }
                start = mid + 1;
            }else {
                if (nums[mid - 1] < target){
                    return mid;
                }
                end = mid - 1;
            }
        }
        return -1;
    }
}
