package com.learnings.arraysandhashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.print(validAnagram.isAnagram("anagram","nagaram"));
    }
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> store = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(char c : s.toCharArray()){
            store.put(c,(store.getOrDefault(c,0)+1));
        }

        for(char c : t.toCharArray()){
           if(!store.containsKey(c)){
               return false;
           } else {
               if(store.get(c) == 1){
                   store.remove(c);
               } else {
                   store.put(c,store.get(c)-1);
               }
           }
        }
        return true;
    }
}
