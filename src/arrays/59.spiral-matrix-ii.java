/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (71.24%)
 * Total Accepted:    7.7K
 * Total Submissions: 10.7K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int end = n * n;
        int index = 1;
        int i = 0, j = -1;

        while (true){
            if (index > end){
                break;
            }
            j++;
            //向右走
            while (j < n && result[i][j] == 0){
                result[i][j] = index++;
                j++;
            }
            j--;
            //向下走
            i++;
            while (i < n && result[i][j] == 0){
                result[i][j] = index++;
                i++;
            }
            i--;
            //向左走
            j--;
            while (j >= 0 && result[i][j] == 0){
                result[i][j] = index++;
                j--;
            }
            j++;
            //向上走
            i--;
            while (i >= 0 && result[i][j] == 0){
                result[i][j] = index++;
                i--;
            }

            //需要从下一行开始
            i++;

        }
        return result;
    }
}
