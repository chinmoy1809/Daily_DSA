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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null ) return list;
        TreeNode node = root;

        while(true){
            if(node != null) {
                st.push(node);
                node=node.left;
            }else{
                if(st.isEmpty()) break;
                TreeNode newNode = st.pop();
                list.add(newNode.val);
                node = newNode.right;
            }
        }
        return list;
    }
}