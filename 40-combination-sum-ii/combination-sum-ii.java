class Solution {

    private void findCombin(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> possAns){
        if(target==0){
            ans.add(new ArrayList<>(possAns));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i] == arr[i-1]){
                continue;
            }

            if(arr[i]>target){
                break;
            }
            possAns.add(arr[i]);
            findCombin(i+1,arr,target-arr[i],ans,possAns);
            possAns.remove(possAns.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombin(0,candidates,target,ans,new ArrayList<>() );
        return ans;
    }
}