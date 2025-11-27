class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int s = 0, e = 0;
        int ans = 0;
        int prev = 0; //no of sub arrays formed previously

        while (e < n) {
            if (left <= nums[e] && nums[e] <= right) {
                prev = e - s + 1;
                ans = ans + prev;
            } else if (nums[e] < left) {
                ans = ans + prev;
            } else { // nums[e] > right
                s = e + 1;
                prev = 0;
            }
            e++;
        }
        return ans;
    }
}