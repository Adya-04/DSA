class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long maxSum = 0;

      
        for(int i = 0; i<n; i++){
            long sum = 0;

            // Peak
            sum += heights[i];

            // Left side
            int prev = heights[i];
            for (int left = i - 1; left >= 0; left--) {
                prev = Math.min(prev, heights[left]);
                sum += prev;
            }

            //Right side
            prev = heights[i];
            for(int right = i+1; right < n ; right++){
                prev = Math.min(prev,heights[right]);
                sum+= prev;
            }

            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}