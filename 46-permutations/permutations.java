class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, ArrayList<Integer> temp, int[] nums){   // If we match the length, it is a permutation
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int n: nums){
            // Skip if we get same element
            if(temp.contains(n)){
                continue;
            }

            // Add the new element
            temp.add(n);

            // Go back to try other element
            backtrack(result,temp,nums);

            // Remove the element
            temp.remove(temp.size()-1);
        }
    }
}