class Solution {

    //Most Bruteforce Sol: O(n^3)
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        while(!isIncreasing(nums)){

            int n = nums.length;
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
        
            //Finding leftmost adjacent pair with min sum
            for (int i=0; i<n-1; i++){
                int sum = nums[i] + nums[i+1];
                if (sum < minSum){
                    minSum = sum;
                    idx = i;
                }
            }

            //building a new Array
            int[] newArr = new int[n-1];
            int k = 0;

            for(int i =0; i<n; i++){
                if(i == idx){
                    newArr[k] = nums[i] + nums[i+1];
                    k++;
                    i++; //Skipping the next element
                }
                else{
                    newArr[k] = nums[i];
                    k++;
                }
            }

            nums = newArr;
            operations++;
        }

        return operations;
    }

    private boolean isIncreasing(int[] arr){
        for(int i = 0; i< arr.length - 1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}
