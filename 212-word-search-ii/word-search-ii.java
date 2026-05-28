class Solution {
    List<String> result = new ArrayList<>();
    int r,c;
    int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    class TrieNode{
        boolean endOfWord = false;
        String word = "";
        TrieNode[] children = new TrieNode[26];
    }

    public TrieNode getNode(){
        return new TrieNode();
    }

    public void insert(TrieNode root, String str){
        TrieNode crawl = root;
        for(char ch: str.toCharArray()){
            if(crawl.children[ch-'a']== null){
                crawl.children[ch-'a'] = getNode();
            }
            crawl = crawl.children[ch-'a'];
        }
        crawl.endOfWord = true;
        crawl.word = str;
    }

    public void DFS(char[][] board, int i, int j, TrieNode root){

        if(i<0 || j<0 || i>=r || j>=c 
            || board[i][j] == '$' 
            || root.children[board[i][j]- 'a'] == null 
        ){
            return;
        }

        root = root.children[board[i][j] - 'a'];

        if(root.endOfWord == true ){
            result.add(root.word);
            root.endOfWord = false; 
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] dir : directions){
            int new_i = i + dir[0];

            int new_j = j + dir[1];

            DFS(board, new_i, new_j, root);
        }

        board[i][j] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        r = board.length;
        c = board[0].length;

        TrieNode root = getNode();

        for(String str : words) {
            insert(root, str);
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {

                char ch = board[i][j];
                if(root.children[ch - 'a'] != null) {
                    DFS(board, i, j, root);
                }
            }
        }
        return result;
    }
}