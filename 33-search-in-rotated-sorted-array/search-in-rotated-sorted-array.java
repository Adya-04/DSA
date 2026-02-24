class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivotIndex = findPivot(nums);

        int idx = binarySearch(0, pivotIndex - 1, nums, target);
        if (idx != -1)
            return idx;
        idx = binarySearch(pivotIndex, n - 1, nums, target);
        return idx;
    }

    public int binarySearch(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums) {
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
        return start;
    }
}