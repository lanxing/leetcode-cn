/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (37.21%)
 * Total Accepted:    52.4K
 * Total Submissions: 136.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //将问题转化为：
        // 寻找排序数组中两个位置a和b，使得nums[a] = target && nums[a - 1] != target
        // nums[b] = target && nums[b+1] != target
        if (nums == null || nums.length < 1){
            return new int[]{-1, -1};
        }
        int a = -1, b = -1;
        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                a = mid;
                break;
            }
            //这里要注意，别忘了等号，mid值大于等于target时，end=mid-1
            if (nums[mid] >= target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                b = mid;
                break;
            }
            //同上，别忘了等号
            if (nums[mid] <= target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return new int[]{a, b};
    }
}
