package Medium.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jing Hu
 * @date Dec. 16 2023
 */
public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        comb(res,new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void comb(List<List<Integer>> res, ArrayList<Integer> list, int start, int n, int k) {
        if(k == 0 ) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n ; i++) {
            list.add(i);
            comb(res,list,i+1,n,k-1);
            list.remove(list.size()-1);
        }
    }
}
