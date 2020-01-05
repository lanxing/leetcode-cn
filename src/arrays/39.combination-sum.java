import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (66.54%)
 * Total Accepted:    53.9K
 * Total Submissions: 79.5K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 使用回溯法
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        deepSearch(result, new ArrayList<>(), candidates, 0, target);
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
        //从index往后开始回溯
        for (int i = index; i < candidates.length; ++i){
            //由于已经排序，所以如果target<candidates[index]，则说明i后边的数都太大，没有必要继续走下去
            if (target < candidates[index]){
                return;
            }
            tmpResult.add(candidates[i]);
            //回溯
            deepSearch(result, tmpResult, candidates, i, target - candidates[i]);
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
