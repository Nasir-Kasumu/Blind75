package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                if(isSame(curr,subRoot)){
                    return true;
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return false;
    }


    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null && q != null){
            return false;
        }
        if(p != null && q == null){
            return false;
        }
        if(p != null && q!= null && p.val != q.val){
            return false;
        }
        return isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
