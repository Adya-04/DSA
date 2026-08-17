class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int n;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(0,nums);
        return result;
    }

    private void solve(int idx, int[] nums) {

        if (idx == n) {
            List<Integer> temp = new ArrayList<>();

            for(int n: nums){
                temp.add(n);
            }

            result.add(temp);
            return;
        }

        for (int i=idx ; i<n; i++) {
            swap(nums,i, idx); //passing indexes to be swapped
            solve(idx+1, nums);
            swap(nums,i,idx);
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}