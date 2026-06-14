class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.sort(nums);
        int i = 0;
        while(i<n){
            arr[i] = nums[i+1];
            arr[i+1] = nums[i];
            i+=2;
        }
        return arr;
    }
}