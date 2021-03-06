public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (candidates == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, 0, result);
        return result;
    }
    void helper(int[] candidates, int target, ArrayList<Integer> path, int pos, ArrayList<ArrayList<Integer>> result) {//把所有以path作为开头, 从pos开始, 和为target的所有解放入result中
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != pos && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i, result);
            path.remove(path.size() - 1);
        }
    }
}

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
Notice
1 All numbers (including target) will be positive integers.
2 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3 The solution set must not contain duplicate combinations.
Example
given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
Tags 
Backtracking Array
*/
