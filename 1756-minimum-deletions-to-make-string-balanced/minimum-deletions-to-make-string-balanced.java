// T.C : O(3*n)
// S.C : O(2*n)
class Solution {
    public int minimumDeletions(String s) {

        int n = s.length();
        
        int[] left_b = new int[n];
        int[] right_a = new int[n];

        int count_b = 0;
        for(int i=0; i<n; i++){
            left_b[i] = count_b;
            if(s.charAt(i) == 'b'){
                count_b++;
            }
        }

        int count_a = 0;
        for(int i=n-1; i>=0 ; i--){
            right_a[i] = count_a;
            if(s.charAt(i) == 'a'){
                count_a++;
            }
        }

        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i<n ; i++){
            minCount = Math.min(minCount,left_b[i]+right_a[i]);
        }
        
        return minCount;
    }
}