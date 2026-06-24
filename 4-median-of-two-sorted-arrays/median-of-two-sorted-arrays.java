class Solution {
    //Better Approach
    // SC = O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while(low <= high){
            int Px = low + (high-low)/2;
            int Py = (m+n+1)/2 - Px;

            //left half wle
            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px-1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];

            //right side wle 
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];

            if(x1<=x4 && x2<=x3){
                if((m+n)%2 == 1) return Math.max(x1,x2);
                else return (Math.max(x1,x2) + Math.min(x3,x4)) / 2.0;
            }

            if(x1>x4){
                //shift leftside 
                high = Px - 1;
            }
            else{
                low = Px+1;
            }
        }
        return -1;
    }
}