/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.65%)
 * Total Accepted:    44.2K
 * Total Submissions: 116.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        boolean allNine = true;
        for (int i = 0; i < len; ++i){
            if (digits[i] == 9){
                continue;
            }
            allNine = false;
            break;
        }
        if (allNine){
            int[] result = new int[len + 1];
            result[0] = 1;
            return result;
        }

        int flag = 1;
        for (int i = len - 1; i >= 0; --i){
            int tmp = digits[i] + flag;
            digits[i] = tmp % 10;
            flag = tmp / 10;
        }
        return digits;
    }
}
