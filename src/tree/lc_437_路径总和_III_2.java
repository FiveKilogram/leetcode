package tree;

import java.util.LinkedList;
import java.util.List;

public class lc_437_路径总和_III_2 {
    public static int pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res  = new LinkedList<>();
        if(root==null){
            return res.size();
        }
        visited(root,targetSum,res);
        System.out.println();
        return res.size();
    }

    public static void find(TreeNode root, List<Integer> list, Integer target,List<List<Integer>> res){
        if(root==null){
            return;
        }
        if(target== root.val){
            list.add(root.val);
            res.add(new LinkedList<>(list));
            list.remove(list.size()-1);
        }
        if(root.left!=null){
            list.add(root.val);
            find(root.left,list,target-root.val,res);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.val);
            find(root.right,list,target-root.val,res);
            list.remove(list.size()-1);
        }

    }

    public static void visited(TreeNode root, Integer target,List<List<Integer>> res){
        if(root==null){
            return;
        }
        find(root,new LinkedList<>(),target,res);
        if(root.right!=null){
            visited(root.right,target,res);
        }
        if(root.left!=null){
            visited(root.left,target,res);
        }
    }
}
