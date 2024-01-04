package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer> >();
        List<Integer> subset = new ArrayList<Integer>();

        findSubsets(nums, 0, subset, result);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < result.size(); i++) {
            res.add(new ArrayList<>(result.get(i)));
        }
        List<Integer> emptyset=new ArrayList<Integer>();
        res.add(emptyset);

        return res;

    }
    static void findSubsets(int [] v, int idx,List<Integer> subset,List<List<Integer> > result)
    {
        if (!subset.isEmpty()) {
            if (!result.contains(subset)) {
                result.add(new ArrayList<>(subset));
            }
        }

        for (int j = idx; j < v.length; j++) {
            subset.add(v[j]);
            findSubsets(v, j + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
