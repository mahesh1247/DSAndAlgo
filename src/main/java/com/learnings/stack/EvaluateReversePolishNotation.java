package com.learnings.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        System.out.println(evaluateReversePolishNotation.evalRPN(new String[]{"2","1","+","3","*"}));
    }

    public int evalRPN(String[] tokens) {
        Set<String> validOperators = new HashSet<>();
        validOperators.add("*");
        validOperators.add("/");
        validOperators.add("+");
        validOperators.add("-");
        Stack<Integer> operands  = new Stack<>();
        int value = 0;
        for(String s: tokens){
            if(validOperators.contains(s.toString())){
                int val1 = operands.pop();
                int val2 = operands.pop();
                if(s.equals("+")){
                    value = val2+val1;
                }
                if(s == "-"){
                    value = val2-val1;
                }
                if(s == "*"){
                    value = val2*val1;
                }
                if(s == "/"){
                    value = val2/val1;
                }
                operands.push(value);
            } else {
                operands.push(Integer.parseInt(s));
            }
        }
        return  value;
    }
}
