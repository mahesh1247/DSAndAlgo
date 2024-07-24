package com.learnings.leetcode;


import java.util.*;

//https://leetcode.com/problems/sort-the-jumbled-numbers/description/
public class SortJumbled {
    public static void main(String[] args) {
        SortJumbled sortJumbled = new SortJumbled();
        sortJumbled.sortJumbled(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{0,1,2,3,4,5,6,7,8,9});
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, List<Integer>> comb = new TreeMap<>();
        for(int i : nums){
            int temp = i;
            int mul = 1;
            int sum = 0;
            if(i != 0) {
                while (i > 0) {
                    int rem = i % 10;
                    i = i / 10;

                    if (mapping[rem] != 0) {
                        sum = (mul * mapping[rem]) + sum;
                    }
                        mul = mul * 10;
                }
            } else {
                sum = mapping[i];
            }
            if(comb.containsKey(sum)){
                comb.get(sum).add(temp);
            } else {
                List<Integer> te = new ArrayList<>();
                te.add(temp);
                comb.put(sum,te);
            }

        }
        int[] result = new int[nums.length];
        int j =0;
        for(Map.Entry<Integer,List<Integer>> res :comb.entrySet()){
           for(int i : res.getValue()){
               result[j] = i;
               j++;
           }
        }
        return result;
    }
}
