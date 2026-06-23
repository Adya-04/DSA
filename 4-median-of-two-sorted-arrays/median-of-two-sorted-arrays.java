class Solution {
    //Better Approach
    // SC = O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;

        int idx1 = (total / 2) - 1;
        int element1 = -1;

        int idx2 = (total / 2);
        int element2 = -1;

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                if (k == idx1) {
                    element1 = nums1[i];
                }
                if (k == idx2) {
                    element2 = nums1[i];
                }
                i++;
            } else {
                if (k == idx1) {
                    element1 = nums2[j];
                }
                if (k == idx2) {
                    element2 = nums2[j];
                }
                j++;
            }

            k++;
        }

        while (i < m) {
            if (k == idx1) {
                element1 = nums1[i];
            }
            if (k == idx2) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }

        while (j < n) {
            if (k == idx1) {
                element1 = nums2[j];
            }
            if (k == idx2) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }

        if (total % 2 == 1) {
            return element2;
        } else {
            return (element1 + element2) / 2.0;
        }
    }
}