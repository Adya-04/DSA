class Solution {
    //Optimal method

    private void findCombin(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> currAns){
        //Base Condition
        if(idx == arr.length){
            if(target==0){
                ans.add(new ArrayList<>(currAns));
            }
            return;
        }

        if(arr[idx] <= target){
            //then only pick 
            currAns.add(arr[idx]);
            findCombin(idx,arr,target-arr[idx],ans,currAns);
            currAns.remove(currAns.size()-1);
        }

        //Not picking the element
        findCombin(idx+1,arr,target,ans,currAns);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findCombin(0,candidates,target,ans,new ArrayList<>());

        return ans;
    }
}