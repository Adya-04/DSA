class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;

        // Slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            max = Math.max(max, sum);
        }

        return (double) max / k;
    }
}