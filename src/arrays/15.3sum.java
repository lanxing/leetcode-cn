import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (21.32%)
 * Total Accepted:    48.6K
 * Total Submissions: 222.5K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length - 2; ++index){
            //跳过第一个数重复的
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            int i = index + 1, j = nums.length - 1;
            while (i < j){
                //跳过第二个重复的
                if (i > index + 1 && nums[i] == nums[i - 1]){
                    i++;
                    continue;
                }
                //跳过第三个重复的
                if (j < nums.length - 1 && nums[j] == nums[j + 1]){
                    j--;
                    continue;
                }
                int tmpValue = nums[index] + nums[i] + nums[j];
                if (tmpValue == 0){
                    List<Integer> tmpResult = new ArrayList<>();
                    tmpResult.add(nums[index]);
                    tmpResult.add(nums[i]);
                    tmpResult.add(nums[j]);
                    result.add(tmpResult);
                    i++;
                    j--;
                }else if (tmpValue > 0){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return result;
    }
}
