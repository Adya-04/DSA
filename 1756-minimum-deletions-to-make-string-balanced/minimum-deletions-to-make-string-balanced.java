// Approach-4 (Constant space)
// T.C : O(2*n)
// S.C : O(1)
class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();

        int counta = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a')
                counta++;
        }

        int count = Integer.MAX_VALUE;
        int countb = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a')
                counta--;
            count = Math.min(count, countb + counta);

            if (s.charAt(i) == 'b')
                countb++;
        }

        return count;
    }
}