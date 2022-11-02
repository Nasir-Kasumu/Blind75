package Trees;

import java.util.ArrayList;

public class KthSmallestElementInABST {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();

    public int kthSmallest(TreeNode root, int k) {
        traverse(root);
        return list.get(k - 1).val;

    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }

        traverse(root.left);
        list.add(root);
        traverse(root.right);
    }
}
