class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i =0; i<n; i++){
            int no = nums[i];
            if(no>0){
                result[i] = nums[(i+no)%n];
            }
            else if(no< 0){
                result[i] = nums[((i + no) % n + n) % n];
            }
            else{
                result[i] = nums[i];
            }
        }
        return result;
    }
}