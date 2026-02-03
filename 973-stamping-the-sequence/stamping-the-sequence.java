class Solution {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();
        int n = T.length, m = S.length;

        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int replaced = 0;

        while (replaced < n) {
            boolean changed = false;

            for (int i = 0; i <= n - m; i++) {
                if (!visited[i] && canReplace(T, i, S)) {
                    replaced += doReplace(T, i, m);
                    visited[i] = true;
                    changed = true;
                    res.add(i);

                    if (replaced == n)
                        break;
                }
            }

            if (!changed)
                return new int[0];
        }

        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    public boolean canReplace(char[] T, int pos, char[] S) {
        for (int i = 0; i < S.length; i++) {
            if (T[i + pos] != '?' && T[i + pos] != S[i]) {
                return false;
            }
        }
        return true;
    }

    private int doReplace(char[] T, int pos, int len) {
        int count = 0;

        for (int j = 0; j < len; j++) {
            if (T[pos + j] != '?') {
                T[pos + j] = '?';
                count++;
            }
        }

        return count;
    }
}