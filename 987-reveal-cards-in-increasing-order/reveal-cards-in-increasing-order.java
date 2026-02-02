class Solution {
    //Approach-1
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;
        Arrays.sort(deck);

        int[] result = new int[n];
        int i = 0; //deck
        int j = 0; //result
        boolean skip = false;

        while(i<n){
            if(result[j] == 0){
                if(skip == false){
                    result[j] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            j = (j+1)%n;
        }
        return result;
    }
}