class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] diffArr = new long[n];

        // Build difference array
        for(int i=0; i<n; i++){
            int left = Math.max(0,i-r);
            int right = i+r+1;

            diffArr[left] += stations[i];
            if(right < n){
                diffArr[right] -= stations[i];
            }
        }


        //Binary Search
        long left = Arrays.stream(stations).min().getAsInt();
        long right = Arrays.stream(stations).asLongStream().sum() + k;
        long result = 0;

        while(left<=right){
            long mid = left + (right-left)/2;
            if(check(mid,diffArr,r,k,n)){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return result;
    }

    public boolean check(long mid,long[] diffArr,int r,long k, int n){
        
        long[] tempDiff = Arrays.copyOf(diffArr ,n);
        long cumSum = 0;

        for(int i=0; i<n; i++){
            cumSum += tempDiff[i];

            if(cumSum < mid){
                long need = mid - cumSum;

                if(need>k) return false;

                //left wli cheez
                cumSum += need;
                
                //right wli cheez
                if(i + 2L*r + 1 < n){
                    tempDiff[(int)(i + 2L * r + 1)] -= need;
                }

                //Since need no of k use hogye to usko k me se minus kr do 
                k = k- need;
            }
        }
        return true;
    }
}