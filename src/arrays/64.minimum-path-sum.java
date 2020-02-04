/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.16%)
 * Total Accepted:    55K
 * Total Submissions: 85.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] tmp = new int[m][n];
        tmp[0][0] = grid[0][0];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (i == 0 && j == 0){
                    continue;
                }
                if (i == 0){
                    tmp[i][j] = tmp[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0){
                    tmp[i][j] = tmp[i - 1][j] + grid[i][j];
                    continue;
                }
                tmp[i][j] = Math.min(tmp[i - 1][j], tmp[i][j - 1]) + grid[i][j];
            }
        }
        return tmp[m - 1][n - 1];
    }
}
