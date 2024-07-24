package com.learnings.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        topKFrequentElements.topKFrequent(new int[]{1,1,1,2,2,3},2);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> kFrequentElements = new HashMap<>();
        for(int i : nums){
            kFrequentElements.put(i,kFrequentElements.getOrDefault(i,0)+1);
        }
        List<Integer>[] freqElemets = new ArrayList[nums.length];

        for(Map.Entry<Integer,Integer> elements: kFrequentElements.entrySet()){
           List freq =  freqElemets[elements.getValue()-1];
           if (freq == null){
               List<Integer> kElemts = new ArrayList<>();
               kElemts.add(elements.getKey());
               freqElemets[elements.getValue()-1] = kElemts;
           } else {
               freq.add(elements.getKey());
           }
        }
        int []result = new int[k] ;
        for (int i = freqElemets.length -1; i>=0 && k>=0; i--){
            if(freqElemets[i] != null){
               for(int j:freqElemets[i]){
                   if(k>0) {
                       result[k - 1] = j;
                       k = k - 1;
                   } else {
                       break;
                   }
               }
            }
        }
        return result;

    }
}
