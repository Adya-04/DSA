class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countAtMost(nums, k) - countAtMost(nums, k - 1);
    }

    //This is the same func we use in binary subarray with sum problem
    private int countAtMost(int[] nums, int K) {
        if (K < 0) return 0;
        
        int left = 0, sum = 0, count = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right] % 2;

            while(sum > K){
                sum -= nums[left] % 2;
                left++;
            }

            // All subarrays ending at right with sum ≤ K
            count += right - left + 1;
        }
        return count;
    }
}