class Solution {
    int m,n,l;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean find(char[][] board, int i, int j, String word, int idx){
        if(idx>=l) return true;

        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != word.charAt(idx)){
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j+ dir[1];
            
            if(find(board, new_i, new_j, word, idx+1)){
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        l = word.length();

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0) && find(board, i, j, word,0)){
                    return true;
                }
            }
        }

        return false;
    }
}