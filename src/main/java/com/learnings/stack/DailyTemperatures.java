package com.learnings.stack;

import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/
public class DailyTemperatures {
    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(dailyTemperatures.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> tempPair = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i =0; i <temperatures.length;i++){
            Pair p = new Pair(temperatures[i],i);
            if(tempPair.isEmpty()){
                tempPair.push(p);
                result[i] = 0;
            } else {
               Pair perviousPair =  tempPair.peek();
               while (perviousPair != null && p.getTemp() > perviousPair.getTemp()){
                   tempPair.pop();
                   result[perviousPair.getIndex()] = p.getIndex() - perviousPair.getIndex();

                   if(!tempPair.isEmpty())
                       perviousPair = tempPair.peek();
                   else
                       perviousPair = null;
               }
                tempPair.push(p);
                result[i] = 0;
            }
        }
        return result;
    }
}

class Pair{
    int temp;
    int index;

    public Pair(int temp, int index) {
        this.temp = temp;
        this.index = index;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
