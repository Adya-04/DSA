class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    private int countAtMost(int[] nums, int K) {
        if (K < 0) return 0;
        
        int left = 0, sum = 0, count = 0;

        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while(sum > K){
                sum -= nums[left];
                left++;
            }

            // All subarrays ending at right with sum ≤ K
            count += right - left + 1;
        }
        return count;
    }
}