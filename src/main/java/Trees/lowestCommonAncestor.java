package Trees;

import java.util.*;
/*
create a mapping map[key:value] = [parentNode,childNode]
populate this map using iterative bfs
traverse the map for p values and add those values to a set
traverse the map for q values
*/

public class lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        que.add(root);
        map.put(null,root);

        while(!que.isEmpty()){
            int len = que.size();

            for(int i = 0; i < len; i++){
                TreeNode curr = que.poll();
                if(curr.left != null){
                    map.put(curr.left,curr);
                    que.add(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right,curr);
                    que.add(curr.right);
                }
            }
        }

        while(p != null){
            set.add(p.val);
            p = map.get(p);
        }

        while(q != null){
            if(set.contains(q.val)){
                return q;
            }else{
                q = map.get(q);
            }
        }


        return null;
    }
}
