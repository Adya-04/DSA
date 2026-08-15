class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // duplicate first element skip
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    ans.add(Arrays.asList(
                        nums[i],
                        nums[left],
                        nums[right]
                    ));

                    left++;
                    right--;

                    // duplicate left values skip
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    // duplicate right values skip
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } 
                else if (sum < 0) {
                    // sum chhota hai → bigger value chahiye
                    left++;
                } 
                else {
                    // sum bada hai → smaller value chahiye
                    right--;
                }
            }
        }

        return ans;
    }
}