class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int left = 1;
        int right = maxSum;
        int ans = 0;

        while (left<=right) {
            int mid = left + (right-left)/2; //Previously what we take as i

            long sum = mid;
            int leftCount = index;
            int rightCount = n - index - 1;

            int extraOnesOnLeft = Math.max(0, leftCount - (mid - 1));

            int validLeftNums = Math.min(leftCount, mid - 1);
            //Adding left Sum
            sum += SideSumFormula(mid, validLeftNums) + extraOnesOnLeft;

            int extraOnesOnRight = Math.max(0, rightCount - (mid - 1));

            int validRightNums = Math.min(rightCount, mid - 1);
            //Adding Right Sum
            sum += SideSumFormula(mid, validRightNums) + extraOnesOnRight;

            if (sum <= maxSum) {
                //feasible ans 
                ans =  mid;
                left = mid+1;
            }
            else right = mid-1; //too large
        }
        return ans;
    }

    public long SideSumFormula(int i, int validNums) {
        return (long) validNums * i
                - (long) validNums * (validNums + 1) / 2;
    }
}