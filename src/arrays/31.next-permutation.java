import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (31.24%)
 * Total Accepted:    35.7K
 * Total Submissions: 110.1K
 * Testcase Example:  '[1,2,3]'
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {

    /**
     * 从数组的最右侧开始，向左遍历，先找到第一个极大值(mid)
     * 将极值左边的第一个数和右边的比该数大的第一个数进行交换
     * 将极值及其右边的数按从小到大进行排序，即可获得下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1){
            return;
        }

        int index = nums.length - 1;
        //获取极大值
        while (index > 0){
            if (nums[index] > nums[index - 1]){
                break;
            }
            --index;
        }
        if (index == 0){
            Arrays.sort(nums);
            return;
        }

        //极大值左边第一个数
        int leftMinValue = nums[index - 1];

        for (int i = nums.length - 1; i >= index; --i){
            //和右边的第一个大于leftMinValue的位置进行交换
            if (nums[i] > leftMinValue){
                swap(nums, i, index - 1);
                break;
            }
        }
        //对index后边的进行排序，将其转变为最小的排列
        Arrays.sort(nums, index, nums.length);

    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
