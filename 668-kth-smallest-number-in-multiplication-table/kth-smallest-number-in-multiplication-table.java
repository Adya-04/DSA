class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        int ans = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(check(mid,m,n,k)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean check(int mid, int m,int n, int k){

        int total = 0;

        for(int i = 1; i<=m ; i++){
            total += Math.min(mid/i,n);
        }

        if(total >= k) return true;
        else return false;
    }
}