package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {

        return findMax(root,0);
    }

    public int findMaxItr(TreeNode root){
        if(root == null){
            return 0;
        }
        int max = 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            depth++;
        }

        return depth;
    }


    public int findMax(TreeNode root, int depth){
        if(root == null){
            return depth;
        }

        depth = Math.max(findMax(root.left, depth + 1),findMax(root.right, depth + 1));

        return depth;
    }
}
