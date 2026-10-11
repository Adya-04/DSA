class Solution {
    Set<List<Integer>> s = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combin = new ArrayList<>();

        getAllCombinations(candidates, 0, target, ans, combin);

        return ans;
    }

    private void getAllCombinations(
        int[] arr,
        int idx,
        int target, 
        List<List<Integer>> ans,
        List<Integer> combin){
        
        if(target==0){
            if(!s.contains(combin)){
                ans.add(new ArrayList<>(combin));
                s.add(new ArrayList<>(combin));
            }
            return;
        }
        
        if(idx == arr.length || target<0){
            return;
        }

        
        // Include the current element
        combin.add(arr[idx]);
        // Single inclusion: move to the next index
        getAllCombinations(arr, idx+1, target-arr[idx], ans, combin);
        // Multiple inclusion: stay at the same index
        getAllCombinations(arr,idx, target-arr[idx], ans, combin);
        // Backtrack: remove the current element
        combin.remove(combin.size()-1);
        //Exclude the current element
        getAllCombinations(arr,idx+1,target,ans,combin);
        
    }
}