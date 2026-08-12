class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //if we hv to do bruteforce without extra space.(HASHSET)
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] ans = new int[Math.min(n1,n2)];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0;
        int j=0;
        int k =0;
        while(i<n1 && j<n2){

            if(nums1[i] == nums2[j]){
                //add only when its not already in ans
                if(k==0 || ans[k-1] != nums1[i]){
                    ans[k++] = nums1[i];
                }
                i++;
                j++;
            }

            else if(nums1[i] > nums2[j]){
                j++;
            }

            else{
                i++;
            }
        }
        return Arrays.copyOf(ans,k);
    }
}