package com.example.leetcode;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 首先每一位相加肯定会产生进位，我们用 carry 表示。
 * 进位最大会是 1 ，因为最大的情况是无非是 9 + 9 + 1 = 19 ，
 * 也就是两个最大的数相加，再加进位，这样最大是 19 ，不会产生进位 2 。下边是伪代码。
 * <p>
 * 初始化一个节点的头，dummy head ，但是这个头不存储数字。并且将 curr 指向它。
 * 初始化进位 carry 为 0 。
 * 初始化 p 和 q 分别为给定的两个链表 l1 和 l2 的头，也就是个位。
 * 循环，直到 l1 和 l2 全部到达 null 。
 * 设置 x 为 p 节点的值，如果 p 已经到达了 null，设置 x 为 0 。
 * 设置 y 为 q 节点的值，如果 q 已经到达了 null，设置 y 为 0 。
 * 设置 sum = x + y + carry 。
 * 更新 carry = sum / 10 。
 * 创建一个值为 sum mod 10 的节点，并将 curr 的 next 指向它，同时 curr 指向变为当前的新节点。
 * 向前移动 p 和 q 。
 * 判断 carry 是否等于 1 ，如果等于 1 ，在链表末尾增加一个为 1 的节点。
 * 返回 dummy head 的 next ，也就是个位数开始的地方。
 * 初始化的节点 dummy head 没有存储值，最后返回 dummy head 的 next 。
 * 这样的好处是不用单独对 head 进行判断改变值。也就是如果一开始的 head 就是代表个位数，
 * 那么开始初始化的时候并不知道它的值是多少，所以还需要在进入循环前单独对它进行值的更正，不能像现在一样只用一个循环简洁。
 */
class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }

}

