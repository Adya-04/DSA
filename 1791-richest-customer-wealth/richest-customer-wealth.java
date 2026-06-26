class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxW = 0;
        for(int[] person : accounts){
            int sum = 0;
            for(int money : person){
                sum+= money;
            }
            maxW = Math.max(sum,maxW);
        }
        return maxW;
    }
}