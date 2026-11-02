class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        getSets(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void getSets(int[] nums, List<Integer> ansSet, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(ansSet));
            return;
        }

        // Choice 1: Pick current element
        ansSet.add(nums[i]);
        // Recursive call
        getSets(nums, ansSet, i + 1);
        // Backtrack
        ansSet.remove(ansSet.size() - 1);

        // Choice 2: Don't pick current element
        getSets(nums, ansSet, i + 1);
    }
}