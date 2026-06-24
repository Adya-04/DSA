class Solution {
    public int maximumTastiness(int[] price, int k) {

        Arrays.sort(price);

        int n = price.length;
        int low = 0;
        int high = price[n - 1] - price[0];
        int possAns = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int possCandies = PossibleCandies(mid,price);
            if (k > possCandies) {
                high = mid - 1;
            } else {
                possAns = mid;
                low = mid + 1;
            }
        }
        return possAns;
    }

    public int PossibleCandies(int mid, int[] price){
        int candiesCount = 0;
        int firstNum = price[0];

        for(int i=1; i<price.length; i++){
            if( (price[i]-firstNum) >= mid){
                candiesCount++;
                firstNum = price[i];
            }
        }
        return candiesCount+1;
    }
}