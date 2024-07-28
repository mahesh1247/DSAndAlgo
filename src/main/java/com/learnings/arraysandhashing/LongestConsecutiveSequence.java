package com.learnings.arraysandhashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for(int i :nums){
            numbers.add(i);
        }
        int maxSeqCount = 0;
        for(int i :nums){
            if(!numbers.contains(i-1)){
                int seqCount = 0;
                seqCount = seqCount +1;
                while(numbers.contains(i+1)){
                    seqCount = seqCount +1;
                    i = i+1;
                }
                maxSeqCount = Math.max(maxSeqCount,seqCount);
            }
        }
        return maxSeqCount;
    }
}
