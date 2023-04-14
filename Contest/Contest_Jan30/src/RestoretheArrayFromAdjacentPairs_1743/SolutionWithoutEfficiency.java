package RestoretheArrayFromAdjacentPairs_1743;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 */
class SolutionWithoutEfficiency {
    public int[] restoreArray(int[][] adjacentPairs) {

        int length = adjacentPairs.length;
        Deque<Integer> numList = new ArrayDeque<>();
        LinkedList<int[]> adj = new LinkedList<>();
        for (int k = 0; k < adjacentPairs.length; k++) {
            adj.add(adjacentPairs[k]);
        }
        numList.add(adj.get(0)[0]);
        numList.add(adj.get(0)[1]);
        adj.remove(0);
        while (!adj.isEmpty()) {
            int j = 0;
            int first = numList.peekFirst();
            int last = numList.peekLast();
            inner:
            while(j<adj.size()){
                if (adj.get(j)[0] == first) {
                    numList.addFirst(adj.get(j)[1]);
                    adj.remove(j);
                    break inner;
                } else if (adj.get(j)[1] == first) {
                    numList.addFirst(adj.get(j)[0]);
                    adj.remove(j);
                    break inner;
                }
                if (adj.get(j)[0] == last) {
                    numList.addLast(adj.get(j)[1]);
                    adj.remove(j);
                } else if (adj.get(j)[1] == last) {
                    numList.addLast(adj.get(j)[0]);
                    adj.remove(j);
                }
                j++;
            }
        }
        int i = 0;
        int[] ints = new int[length+1];
        while (!numList.isEmpty()){
            ints[i] = numList.pop();
            i++;
        }
        return ints;
    }
}
