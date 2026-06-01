class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int minCost = 0;
        int len = cost.length;

        for (int i = 0; i < len; i++) {
            if ((len - i) % 3 != 0) {
                minCost += cost[i];
            }
        }

        return minCost;
    }
}