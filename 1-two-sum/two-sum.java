class Solution {
    //Time: O(n)
// Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<n; i++){
           int compl = target - nums[i];

           if(map.containsKey(compl)){
                return new int[]{map.get(compl), i};
           }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}