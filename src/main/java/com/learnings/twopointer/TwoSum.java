package com.learnings.twopointer;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length;
        while (start < end){
            int sum = numbers[start]+numbers[end];
            if(sum == target){
                return new int[]{start,end};
            } else if (sum < target){
                start = start +1;
            } else if (sum > target) {
             end = end -1;
            }

            }
        return null;
        }
    }


