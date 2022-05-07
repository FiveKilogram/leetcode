package tree;

import java.util.LinkedList;
import java.util.List;

public class lc_437_路径总和_III {
    static  int num;
    public static void main(String[] args) {
        lc_437_路径总和_III c =new lc_437_路径总和_III();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(3);
        treeNode.right.right.right = new TreeNode(4);
        treeNode.right.right.right.right = new TreeNode(5);
        c.pathSum(treeNode,3);
    }
    public void find(TreeNode root, Integer target){
        if(root==null){
            return;
        }
        if(target== root.val){
            num++;
        }
        if(root.left!=null){
            find(root.left,target-root.val);
        }
        if(root.right!=null){
            find(root.right,target-root.val);
        }

    }

    public int pathSum(TreeNode root, Integer targetSum){
        if(root==null){
            return 0;
        }
        find(root,targetSum);
        if(root.right!=null){
            pathSum(root.right,targetSum);
        }
        if(root.left!=null){
            pathSum(root.left,targetSum);
        }
        return num;
    }



}
