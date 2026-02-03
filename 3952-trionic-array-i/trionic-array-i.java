class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 0;

        while(i+1<n && nums[i] < nums[i+1]){ //i+1<n to check when comparing i+1 dont get out of bound
            i++;
        }
        // Must have at least one increasing step and not reach end
        if(i==0 || i==n-1) return false;

        while(i+1<n && nums[i] > nums[i+1]){
            i++;
        }
        // Must have at least one decreasing step and not reach end
        if(i==n-1) return false;

        while(i+1<n && nums[i] < nums[i+1]){
            i++;
        }
        return (i==n-1);
    }
}