import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (34.13%)
 * Total Accepted:    12.3K
 * Total Submissions: 35.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0){
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        int maxTimes = Math.min(m, n) / 2;
        int times = 0;
        while (times <= maxTimes) {
            int i = times;
            int j = n - 1 - times;
            //从左向右
            if (i > j){
                break;
            }
            for (int index = i; index <= j; ++index) {
                result.add(matrix[i][index]);
            }
            //从上到下
            if (i + 1 >= m - i){
                break;
            }
            for (int index = i + 1; index < m - i; ++index) {
                result.add(matrix[index][j]);
            }
            //从右向左
            if (j - 1 < i){
                break;
            }
            for (int index = j - 1; index >= i; --index) {
                result.add(matrix[m - i - 1][index]);
            }
            //从下向上
            if (m - i - 2 <= i){
                break;
            }
            for (int index = m - i - 2; index > i; --index) {
                result.add(matrix[index][i]);
            }
            times++;
        }
        return result;
    }
}
