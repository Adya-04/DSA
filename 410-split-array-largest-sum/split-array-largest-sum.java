class Solution {
    public int splitArray(int[] nums, int k) {
        int ans = 0;

        int totalSum = 0;
        int max = nums[0];
        for(int n : nums){
            totalSum += n;
            if(n>max) max = n;
        }
        
        int low = max;
        int high = totalSum;

        while(low<=high){
            int mid = low + (high-low)/2;

            // for max = mid ,what is the number of ks forming
            int possK = FindPossibleKFor(mid,nums);

            if(possK <= k){
                ans = mid; // poss ans 
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public int FindPossibleKFor(int maxNum, int[] nums){
        int ans = 1; // ans shouldnot be 0 bcz this func retunr no of splits not no of subaarays
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+= nums[i];
            if(sum>maxNum){
                sum = nums[i];
                ans++;
            }
        }
        return ans;
    }
}