import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 *
 * https://leetcode-cn.com/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (53.72%)
 * Total Accepted:    27.7K
 * Total Submissions: 50.4K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: 
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出: 
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: 
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出: 
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 
 * 进阶:
 * 
 * 
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * 
 * 
 */
class Solution {
    //空间复杂度为m+n
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (matrix[i][j] == 0){
                    tmp.add(i * n + j);
                }
            }
        }

        for (Integer i : tmp){
            int mi = i / n;
            int nj = i % n;
            setZero(matrix, mi, nj, m, n);
        }
    }

    public setZero(int[][] matrix, int i, int j, int m, int n){

        int tmp = 0;
        while (tmp < n){
            matrix[i][tmp] = 0;
            tmp++;
        }
        tmp = 0;
        while (tmp < m){
            matrix[tmp][j] = 0;
            tmp++;
        }
    }
}
