package arrays;/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (33.11%)
 * Total Accepted:    124K
 * Total Submissions: 364.9K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */


 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tmpNode = head;
        int flag = 0;
        int tmpValue = 0;
        while (l1 != null || l2 != null){
            if (l1 != null){
                tmpValue += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                tmpValue += l2.val;
                l2 = l2.next;
            }
            tmpValue += flag;
            ListNode node = new ListNode(tmpValue % 10);
            if (head == null){
                head = node;
                tmpNode = head;
            }else {
                tmpNode = node;
                tmpNode.next = head;
                head = tmpNode;
            }
            flag = tmpValue / 10;
            tmpValue = 0;
        }
        if (flag > 0){
            ListNode node = new ListNode(flag);
            tmpNode = node;
            tmpNode.next = head;
        }
        return tmpNode;
    }
}
