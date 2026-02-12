class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int n = nums.length;
        int h = n-1;

        while(l<h){
            int mid = l + (h-l)/2;
            boolean isEven = (h-mid)%2 == 0;
            if(nums[mid] == nums[mid+1]){
                if(isEven){
                    l = mid+2;
                }
                else{
                    h = mid-1;
                }
            }
            else{
                if(isEven){
                    h = mid;
                }
                else{
                    l = mid+1;
                }
            }
        }
        return nums[l];
    }
}