/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (42.04%)
 * Total Accepted:    10.2K
 * Total Submissions: 24.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
class Solution {
    /**
     * 解题思路，先找最大值，然后从两边向最大值遍历，只要比上一个记录的最大值小的就可以盛水，大的则更新最大值
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 1){
            return 0;
        }
        //最大值所在的位置
        int maxIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; ++i){
            if (height[i] > maxValue){
                maxIndex = i;
                maxValue = height[i];
            }
        }
        int area = 0;
        //上一个最大值
        int lastValue = height[0];
        for (int start = 1; start < maxIndex; ++start){
            //只要比上一个最大值小，就可以盛水
            if (height[start] < lastValue){
                area += (lastValue - height[start]);
            }else if (height[start] > lastValue){
                //如果比最大值大，则更新最大值
                lastValue = height[start];
            }
        }
        //同上
        lastValue = height[height.length - 1];
        for (int end = height.length - 2; end > maxIndex; --end){
            if (height[end] < lastValue){
                area += (lastValue - height[end]);
            }else if (height[end] > lastValue){
                lastValue = height[end];
            }
        }
        return area;
    }
}
