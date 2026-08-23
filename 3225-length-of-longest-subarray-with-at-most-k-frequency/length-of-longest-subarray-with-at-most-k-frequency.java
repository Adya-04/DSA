class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        int maxLength = 0;

        for (int j = 0; j < nums.length; j++) {
            // Expand the window: Add current element to frequency map
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Shrink the window if frequency of nums[j] exceeds k
            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            // Update maximum valid subarray length found so far
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}