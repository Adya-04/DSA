class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        long result = 0;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            pairs += map.getOrDefault(nums[r], 0);
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (pairs >= k) {
                result += n - r;
                pairs -= map.get(nums[l]) - 1; // remove old contribution
                map.put(nums[l], map.get(nums[l]) - 1); // reduce frequency

                l++;
            }
            r++;
        }
        return result;
    }
}