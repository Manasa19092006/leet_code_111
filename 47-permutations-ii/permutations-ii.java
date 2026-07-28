import java.util.*;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }
    private void backtrack(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums, index, i);
            backtrack(nums, index + 1, ans);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}