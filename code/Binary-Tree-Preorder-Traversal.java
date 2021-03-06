/**
 * Problem Statement
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * /

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ArrayList rnt = new ArrayList();
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        if(root==null) return rnt;
       
        rnt.add(root.val);
        
        if(root.left!=null) preorderTraversal(root.left);
        if(root.right!=null) preorderTraversal(root.right);
        
        return rnt;
        
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity O(n)
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //special case
        if(root==null) return rnt;
        
        //preorder traversal
        rnt.add(root.val);
        if(root.left!=null) preorderTraversal(root.left);
        if(root.right!=null) preorderTraversal(root.right);
        
        return rnt;
    }
}


////////////////////////////////////////////
// 2015/11/09
// Highlight: recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        preorder(rnt, root);
        return rnt;
    }
    
    public void preorder(ArrayList<Integer> rnt, TreeNode root){
        if(root==null) return;
        rnt.add(root.val);
        preorder(rnt, root.left);
        preorder(rnt, root.right);
    }
}

/////////////////////////////////////////////
// 2015/11/30
// Preorder, iterative
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rnt = new ArrayList<Integer>();
        if(root==null) return rnt;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //current node
            rnt.add(node.val);
            
            //push right
            if(node.right!=null)
                stack.push(node.right);
            //push left
            if(node.left!=null)
                stack.push(node.left);
        }
        
        return rnt;
    }
}
