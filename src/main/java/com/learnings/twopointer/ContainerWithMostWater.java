package com.learnings.twopointer;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {

    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxHeight = 0;
        int start = 0;
        int end = height.length -1;
        while (start < end){
            int h = Math.min(height[start],height[end]) * (end -start);
            maxHeight = Math.max(maxHeight,h);
            if (height[start] < height[end]){
                start = start +1;
            } else if (height[start] > height[end]) {
                end = end -1;
            } else {
                start = start +1;
            }

        }
        return maxHeight;
    }

}
