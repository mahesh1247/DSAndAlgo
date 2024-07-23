package com.learnings.arraysandhashing;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/submissions/
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character,Integer>,List<String>> annagramsMap = new LinkedHashMap<>();
        for(String s: strs){
            Map<Character,Integer> charCount = new HashMap<>();
            for(char c: s.toCharArray()){
                charCount.put(c,(charCount.getOrDefault(c,0)+1));
            }
            if(annagramsMap.containsKey(charCount)){
               annagramsMap.get(charCount).add(s);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                annagramsMap.put(charCount,stringList);
            }
        }
        for (Map.Entry<Map<Character,Integer>,List<String>> elements : annagramsMap.entrySet()){
            result.add(elements.getValue());
        }
        return result;
    }
}
