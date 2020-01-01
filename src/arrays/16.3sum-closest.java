import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (41.27%)
 * Total Accepted:    63.3K
 * Total Submissions: 149.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int abs = Integer.MAX_VALUE;
        int result = 0;
        for (int index = 0; index < nums.length - 2; ++index){
            int i = index + 1, j = nums.length - 1;
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            while (i < j){
                if (i > index + 1 && nums[i] == nums[i - 1]){
                    i++;
                    continue;
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]){
                    j--;
                    continue;
                }
                int tmpV = nums[index] + nums[i] + nums[j];
                int tmpAbs = Math.abs(tmpV - target);
                if (tmpAbs < abs){
                    result = tmpV;
                    abs = tmpAbs;
                }
                if (abs == 0){
                    return result;
                }
                if (tmpV < target){
                    i++;
                }else {
                    j--;
                }
            }
        }
        return result;
    }
}
