import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (35.93%)
 * Total Accepted:    47.4K
 * Total Submissions: 130K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        for (int index1 = 0; index1 < nums.length - 3; ++index1){
            if (index1 > 0 && nums[index1] == nums[index1 - 1]){
                continue;
            }
            for (int index2 = index1 + 1; index2 < nums.length - 2; ++index2) {
                if (index2 > index1 + 1 && nums[index2] == nums[index2 - 1]) {
                    continue;
                }
                int i = index2 + 1, j = nums.length - 1;
                while (i < j) {
                    if (i > index2 + 1 && nums[i] == nums[i - 1]) {
                        i++;
                        continue;
                    }
                    if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                        j--;
                        continue;
                    }
                    int tmpResult = nums[index1] + nums[index2] + nums[i] + nums[j];
                    if (tmpResult == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[index1]);
                        tmp.add(nums[index2]);
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        result.add(tmp);
                    }
                    if (tmpResult < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return result;
    }
}
