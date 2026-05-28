class Trie {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode crawl = root;
        for(char ch: word.toCharArray()){
            if(crawl.children[ch - 'a'] == null){
                crawl.children[ch - 'a'] = new TrieNode();
            }
            crawl = crawl.children[ch - 'a'];
        }
        crawl.endOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode crawl = root;

        for(char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if(crawl.children[idx] == null) {

                return false;
            }

            crawl = crawl.children[idx];
        }

        return crawl.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode crawl = root;

        for(char ch : prefix.toCharArray()) {

            int idx = ch - 'a';

            if(crawl.children[idx] == null) {

                return false;
            }

            crawl = crawl.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */