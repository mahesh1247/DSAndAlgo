package com.learnings.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> characterMap = new HashMap<>();
        characterMap.put(')','(');
        characterMap.put('}','{');
        characterMap.put(']','[');
        for(char c : s.toCharArray()){
            if(characterMap.containsKey(c)){
                if(stack.isEmpty() || stack.pop() != characterMap.get(c)){
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}

