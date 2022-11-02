package Trees;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValid(root,null,null);
    }

    public boolean isValid(TreeNode root, Integer leftBound, Integer rightBound){
        if(root == null){
            return true;
        }


        if(leftBound != null && root.val <= leftBound){
            return false;
        }
        if(rightBound != null && root.val >= rightBound){
            return false;
        }


        return isValid(root.left,leftBound,root.val) && isValid(root.right,root.val,rightBound);
    }
}
