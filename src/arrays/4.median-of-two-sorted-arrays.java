/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (33.82%)
 * Total Accepted:    40.5K
 * Total Submissions: 119.6K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return force(nums1, nums2);
//        return binarySearch(nums1, nums2);
    }

    /**
     * 暴力解法，先合并再找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double force(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0){
            return median(nums2);
        }
        if (nums2 == null || nums2.length == 0){
            return median(nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int times = -1;
        boolean odd = (len1 + len2) % 2 == 1;
        int half = (len1 + len2) / 2 - 1;

        int i = 0, j = 0;
        int val1 = 0, val2 = 0;
        int tmpValue;
        while (i < len1 || j < len2){
            if (i == len1){
                tmpValue = nums2[j];
                j++;
            }else if (j == len2){
                tmpValue = nums1[i];
                i++;
            }else if (nums1[i] < nums2[j]){
                tmpValue = nums1[i];
                i++;
            }else {
                tmpValue = nums2[j];
                j++;
            }
            times++;
            if (times == half){
                val1 = tmpValue;
            }else if (times == half + 1){
                val2 = tmpValue;
            }
        }
        if (odd){
            return val2;
        }else {
            return (val1 + val2) / 2.0;
        }

    }

    private double median(int nums[]){
        int len = nums.length;
        if (len % 2 == 1){
            return nums[len / 2];
        }
        return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
    }

    private double binarySearch(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length){
            return binarySearch(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        while (low <= high){
            // partition A position i
            int i = low + (high - low) / 2;
            // partition B position j
            int j = (m + n + 1) / 2 - i;

            int maxLeftA = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = i == m ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = j == n ? Integer.MAX_VALUE : nums2[j];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // total length is even
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                } else {
                    // total length is odd
                    return (double) Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // binary search left half
                high = i - 1;
            } else {
                // binary search right half
                low = i + 1;
            }
        }
        return 0;
    }
}

