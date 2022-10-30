package Trees;
/*
pre - [3,9,20,15,7]
in - [9,3,15,20,7]

use pre [0] as root b/c pre always starts root->left->right
use the index value of pre[0] at in as a reference point in inorder
in[indexOf(pre[0])] shows us the midpoint of the array
split that inorder midpoint into left and right subarrays
    inLeft [9] mid[3] inRight [15,20,7]
    repeat the process recursively building tree
 */

import java.util.Arrays;

public class ConstructBinaryTreeFromPreOrderAndInorder {
    public TreeNode buildTree(int [] pre, int [] in){
        if(pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int mid = findMid(in, root.val);

        root.left = buildTree(
                Arrays.copyOfRange(pre, 1, mid + 1),
                Arrays.copyOfRange(in, 0, mid)
                );
        root.right = buildTree(
                Arrays.copyOfRange(pre, mid + 1, pre.length),
                Arrays.copyOfRange(in, mid + 1, in.length)
        );
        return root;
    }

    public int findMid(int [] arr, int val){
        int mid = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == mid){
                return i;
            }
        }
        return mid;
    }
}
