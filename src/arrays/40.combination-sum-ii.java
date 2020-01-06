import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (56.16%)
 * Total Accepted:    34K
 * Total Submissions: 57.5K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 解题思路跟39是一样的，只是需要进行去重处理
 */
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        deepSearch(result, new ArrayList<>(), candidates, -1, target);
        return result;
    }

    /**
     * 回溯法
     * @param result
     * @param tmpResult 存储临时满足的数据
     * @param candidates
     * @param index 当前栈顶的位置
     * @param target 和需要满足的值
     */
    private void deepSearch(List<List<Integer>> result, List<Integer> tmpResult, int[] candidates, int index, int target){
        /**
         * 如果target=0，说明tmpResult中的值满足要求
         */
        if (target == 0){
            result.add(this.copy(tmpResult));
        }
        //因为不能重复使用，所以从index+1开始遍历（与39不一样）
        for (int i = index + 1; i < candidates.length; ++i){
            //由于已经排序，所以如果target<candidates[index]，则说明i后边的数都太大，没有必要继续走下去
            if (index >= 0 && target < candidates[index]){
                return;
            }
            tmpResult.add(candidates[i]);
            //回溯
            deepSearch(result, tmpResult, candidates, i, target - candidates[i]);
            //这里需要进行去重，如果后边的和当前的值一样，就没必要再进行下去了
            while (i < candidates.length){
                if (i < candidates.length - 1 && candidates[i] != candidates[i + 1]){
                    break;
                }
                ++i;
            }
            //弹出最后一个值
            tmpResult.remove(tmpResult.size() - 1);
        }
    }

    private List<Integer> copy(List<Integer> t){
        List<Integer> result = new ArrayList<>();
        for (int i : t){
            result.add(i);
        }
        return result;
    }
}
