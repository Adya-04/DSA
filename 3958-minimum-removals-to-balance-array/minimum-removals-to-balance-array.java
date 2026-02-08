//Coded myself
class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);         
        int n = nums.length;    

        int l = 0, r = 0;
        int maxLen = 1;

        while (r < n) {

            int max = nums[r];
            int min = nums[l];

            if ((long) max <= (long) k * min) {  
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                l++;
            }
        }

        return n - maxLen;
    }
}