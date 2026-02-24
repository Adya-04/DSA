class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                // Minimum is in right half
                start = mid + 1;
            } else {
                // Minimum is at mid or left half
                end = mid;
            }
        }
        return nums[start];
    }
}