class Solution {

    int m, n;
    int[][] t = new int[1001][1001];

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        for (int i = 0; i < 1001; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(s1, s2, 0, 0);
    }

    int solve(String s1, String s2, int i, int j) {

        // Base condition
        if (i >= m && j >= n) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (i >= m) {
            return t[i][j] = s2.charAt(j) + solve(s1, s2, i, j + 1);
        }

        if (j >= n) {
            return t[i][j] = s1.charAt(i) + solve(s1, s2, i + 1, j);
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return t[i][j] = solve(s1, s2, i + 1, j + 1);
        }

        int takeS1 = s1.charAt(i) + solve(s1, s2, i + 1, j);
        int takeS2 = s2.charAt(j) + solve(s1, s2, i, j + 1);

        return t[i][j] = Math.min(takeS1, takeS2);
    }
}
