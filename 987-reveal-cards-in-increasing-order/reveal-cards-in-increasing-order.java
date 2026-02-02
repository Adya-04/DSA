class Solution {
    //Approach-2 using queue
    public int[] deckRevealedIncreasing(int[] deck) {

        int n = deck.length;

        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[n];

        Arrays.sort(deck);

        for(int i = 0; i<n; i++){
            q.offer(i);
        }

        for (int i = 0; i < n; i++) {
            int idx = q.poll();
            result[idx] = deck[i];
            
            if (!q.isEmpty()) {
                q.offer(q.peek());
                q.poll();
            }
        }
        return result;
    }
}