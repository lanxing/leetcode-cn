/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.09%)
 * Total Accepted:    63.9K
 * Total Submissions: 176.2K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * 
 */
class Solution {
    /**
     * 解题思路
     * 1. 先确定target是否存在(可以根据数组第一个值和最后一个值比较得到)，先过滤一部分
     * 2. 确定target在左边递增部分还是右边递增部分，原理同上
     * 3. 每次循环判断mid是在左边递增部分还是右边递增部分，然后根据2的判断结果决定搜索左半部分还是右半部分。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int startValue = nums[0], endValue = nums[nums.length - 1];

        //说明不存在
        if (target < startValue && target > endValue){
            return -1;
        }

        //用来表示target是在左边递增还是右边递增
        boolean targetFlag = target >= startValue;

        int start = 0, end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            int midValue = nums[mid];
            if (midValue == target){
                return mid;
            }
            if (midValue >= startValue){
                //说明mid在左边递增部分
                if (targetFlag){
                    //并且target在左边递增部分，需要判断一下当前值和target的大小
                    if (midValue > target){
                        end = mid - 1;
                    }else {
                        start = mid + 1;
                    }
                }else {
                    //target在右边递增部分，则start直接等于mid+1;
                    start = mid + 1;
                }
            }else if (midValue <= endValue){
                //说明mid在右边递增部分
                if (targetFlag){
                    //如果target在左边递增部分，则end=mid - 1
                    end = mid - 1;
                }else {
                    //需要判断一下当前值和target大小
                    if (midValue < target){
                        start = mid + 1;
                    }else {
                        end = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
