package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列
 * 表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 考察点：回溯+剪枝
 *
 *
 */

public class lc39_组合总和 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        find(result,candidates,target,0, path);
        return result;
    }

    private static void find(List<List<Integer>> result, int[] candidates, int target, int position,List<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = position; i < candidates.length; i++) {
            path.add(candidates[i]);
            find(result,candidates,target-candidates[i],i, path);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {

        int num[] = new int[]{2,3,5};
        int target = 8;
        List<List<Integer>> lists = combinationSum(num, target);
        System.out.println(lists);
    }

}
