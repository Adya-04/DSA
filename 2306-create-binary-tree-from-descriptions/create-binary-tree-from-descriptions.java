/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {

        //Set for checking childs existing
        Set<Integer> childSet = new HashSet<>();

        //Set for checking hash set
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeftChild = (desc[2] == 1);

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            if (isLeftChild) {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }

            childSet.add(child);
        }

        for (int[] desc : descriptions) {
            int parent = desc[0];
            if (!childSet.contains(parent)) {
                return map.get(parent);
            }
        }
        
        return null;
    }
}