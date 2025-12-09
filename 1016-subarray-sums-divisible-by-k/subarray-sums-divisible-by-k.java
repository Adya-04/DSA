class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

         // freq[r] = how many prefix sums have remainder r
        int[] freq = new int[k];
        freq[0] = 1;  // Prefix with remainder 0 counts as a valid subarray

        for(int num: nums){
            prefixSum += num;

            // Normalize remainder for negative values
            int remainder = ((prefixSum % k) + k) % k;

            // Add how many times we've seen this remainder before
            count += freq[remainder];

            // Increase the count for this remainder
            freq[remainder]++;
        }
        return count;
    }
}