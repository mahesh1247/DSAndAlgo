package com.learnings.arraysandhashing;

import java.util.HashSet;
import java.util.Set;


//https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.print(containsDuplicate.containsDuplicate(new int[]{1,2,3,4,5,1}));
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> elementsStore = new HashSet<>();
        for(int i : nums){
            if(elementsStore.contains(i)){
                return true;
            } else {
                elementsStore.add(i);
            }
        }
        return false;
    }
}
