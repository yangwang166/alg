public class Solution {
    public int maxDiffSubArrays(int[] nums) {
        int size = nums.length;
        int[] left_max = new int[size];//从0开始到i的最大子数组的和
        int[] left_min = new int[size];//从0开始到i的最小子数组的和
        int[] right_max = new int[size];//从i到size-1的最大子数组和
        int[] right_min = new int[size];//从i到size-1的最小子数组和
        int[] copy = new int[size];
        /*Get negative copy*/
        for(int i = 0; i < size; i++){
            copy[i] = -1 * nums[i];
        }

        /*Forward: get max subarray*/
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for(int i = 0; i < size; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_max[i] = max;
        }

        /*Backward: get max subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size - 1; i >= 0; i--){
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_max[i] = max;
        }

        /*Forward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = 0; i < size; i++){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left_min[i] = -1 * max;
        }

        /*Backward: get min subarray*/
        max = Integer.MIN_VALUE;
        sum = 0;
        minSum = 0;
        for(int i = size - 1; i >= 0; i--){
            sum += copy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right_min[i] = -1 * max;
        }

        int diff = 0;
        for(int i = 0; i < size - 1; i++){
            diff = Math.max(diff, Math.abs(left_max[i] - right_min[i + 1]));
            diff = Math.max(diff, Math.abs(left_min[i] - right_max[i + 1]));
        }
        return diff;
    }
}

/*
Given an array with integers.
Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.
Return the largest difference.
Notice
The subarray should contain at least one number
Example
For [1, 2, -3, 1], return 6.
Challenge 
O(n) time and O(n) space.
Tags: Greedy, Enumeration, Array, Subarray, Forward-Backward Traversal
*/
