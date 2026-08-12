class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] ans = new int[Math.min(n1, n2)];

        HashMap<Integer, Integer> map = new HashMap<>();

        // store frequencies of nums1 
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int k = 0;

        // check nums2 
        for (int x : nums2) {
            if (map.getOrDefault(x, 0) > 0) {
                ans[k++] = x;
                map.put(x, map.get(x) - 1);
            }
        }
        return Arrays.copyOf(ans, k);
    }
}