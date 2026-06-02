class Solution {

    static class TrieNode{
        TrieNode left;
        TrieNode right;
    }

    public void insert(TrieNode head, int num){
        TrieNode pCrawl = head;
        for(int i =31; i>=0; i--){
            int ithBit = (num>>i) & 1;
            if(ithBit == 0){
                if(pCrawl.left == null){
                    pCrawl.left = new TrieNode();
                }
                pCrawl = pCrawl.left;
            } 
            else{
                if(pCrawl.right == null){
                    pCrawl.right = new TrieNode();
                }
                pCrawl = pCrawl.right;
            }
        }
    }

    public int maxXOR(TrieNode head, int num){
        int maxXor = 0;
        TrieNode pCrawl = head;

        for (int i = 31; i>=0; i--){
            int ithBit = (num>>i) & 1;
            if(ithBit == 1){
                if(pCrawl.left != null){
                    maxXor += Math.pow(2,i);
                    pCrawl = pCrawl.left;
                }
                else{
                    pCrawl = pCrawl.right;
                }
            }
            else{
                if(pCrawl.right != null){
                    maxXor += Math.pow(2,i);
                    pCrawl = pCrawl.right;
                }
                else{
                    pCrawl = pCrawl.left;
                }
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for(int x: nums){
            insert(root, x);
        }

        int result = 0;

        for(int x: nums){
            result = Math.max(result, maxXOR(root, x));
        }
        return result;
    }
}