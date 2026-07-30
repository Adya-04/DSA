class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long ans = 0;

        long left = -1_000_000_0000L;
        long right = 1_000_000_0000L;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (check(mid, k, nums1, nums2)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(long midProduct, long k, int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums2.length;

        for (int a : nums1) {
            if (a >= 0) {
                int l = 0, r = n - 1, pos = -1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    long product = 1L * a * nums2[m];
                    if (product <= midProduct) {
                        pos = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += (pos + 1);
            } else {
                int l = 0, r = n - 1, pos = n;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    long product = 1L * a * nums2[m];
                    if (product <= midProduct) {
                        pos = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += (n - pos);
            }
        }

        return count >= k;
    }
}