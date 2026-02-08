class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length -1;
        int[] ans = {-1,-1};
        int possAns = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                possAns = mid;
                e = mid-1;
            }
            else if(nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid + 1;
            }
        }
        ans[0] = possAns;

        s = 0;
        e = nums.length - 1;
        possAns = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                possAns = mid;
                s = mid+1;
            }
            else if(nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid + 1;
            }
        }
        ans[1] = possAns;

        return ans;
    }
}