class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0;
        int rSum = 0;
        int max = 0;

        // Take first k cards from left
        for(int i=0 ; i<k; i++){
            lSum += cardPoints[i];
        }
        max = lSum; //asuming it is max value

        int rIndex = n-1;
        // Slide window: remove from left, add from right
        for(int i = k-1; i>=0; i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[rIndex];
            rIndex--;
            max = Math.max(lSum+rSum,max);
        }
    return max;
    }
}