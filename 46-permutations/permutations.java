class Solution {

    List<List<Integer>> result = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        List<Integer> temp = new ArrayList<>();
        solve(temp,nums);
        return result;
    }

    private void solve(List<Integer> temp, int[] nums) {

        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<nums.length; i++) {

            if (!set.contains(nums[i])) {
                temp.add(nums[i]);
                set.add(nums[i]);

                solve(temp, nums);

                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}