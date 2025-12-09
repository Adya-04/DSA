class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int oddCount = 0;
        int result = 0;

        for(int num: nums){
            oddCount += num % 2;  // same as this -> if(num%2 !=0) oddCount++;

            // Check if we have seen (oddCount - k)
            result += map.getOrDefault(oddCount - k, 0);
        
            // Store current oddCount into the map
            map.put(oddCount, map.getOrDefault(oddCount,0)+1);
        }
        return result;
    }
}