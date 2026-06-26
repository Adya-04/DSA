class Solution {
    public int[] sortedSquares(int[] nums) {
        //O(n) Time Complexity
        int n = nums.length;
        int[] ans = new int[n];

        int i = 0;
        int j = n-1;
        int newArrIdx = n-1;

        while(i<=j) {

            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                ans[newArrIdx--] = nums[i] * nums[i];
                i++;
            }
            else{
                ans[newArrIdx--] = nums[j] * nums[j];
                j--;
            }
        }
        return ans;
    }
}