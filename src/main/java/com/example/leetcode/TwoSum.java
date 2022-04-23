package com.example.leetcode;
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i], i);
        }
        for(int i = 0;i < nums.length;i++){
            int sub = target - nums[i];
            if(map.containsKey(sub) && map.get(sub) != i){
                return new int[]{i,map.get(sub)};
            }
        }
        throw new IllegalArgumentException("no");
    }
}
