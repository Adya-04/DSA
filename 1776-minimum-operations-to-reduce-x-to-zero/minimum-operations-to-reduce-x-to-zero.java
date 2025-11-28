class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum =0;

        HashMap<Integer, Integer> map = new HashMap<>();  
        map.put(0, -1);
        
        for(int i =0; i<n; i++){
            sum+= nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i); // store earliest index
            }
        }

        if (sum < x)
            return -1;

        int target = sum - x; //Now we have to find longest subarray whose sum = target

        sum = 0;//now again traversing for getting sum at each index
        int maxLen = -1; //ans

        for (int i = 0; i < n; i++) {
            sum+= nums[i];
            int toFind = sum - target;
            if(map.containsKey(toFind)){
                int index = map.get(toFind);
                int l = i-index;
                maxLen = Math.max(maxLen, l);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}