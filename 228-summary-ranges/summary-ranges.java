class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < nums.length) {
            int start = nums[i];

            // Find the end of the current consecutive range
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            int end = nums[i];

            // Single number
            if (start == end) {
                ans.add(String.valueOf(start));
            }
            // Range
            else {
                ans.add(start + "->" + end);
            }

            i++;
        }

        return ans;
    }
}