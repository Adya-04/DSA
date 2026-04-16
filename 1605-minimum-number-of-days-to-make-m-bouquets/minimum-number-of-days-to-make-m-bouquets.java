class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k>n) return -1;

        int start = 1;
        int minDays = -1;
        int end = Arrays.stream(bloomDay).max().getAsInt();

        while(start<=end){
            int mid = start + (end-start)/2 ;
            if(getNumOfBouquets(bloomDay,mid,k)>=m){
                minDays = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return minDays;
    }

    public int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int currFlowerCount = 0;

        for(int i =0; i<bloomDay.length; i++){
            if(bloomDay[i]<=mid){
                currFlowerCount++;
            }
            else{
                currFlowerCount =0;
            }
            if(currFlowerCount == k){
                numOfBouquets++;
                currFlowerCount =0;
            }
        }
        return numOfBouquets;
    }
}