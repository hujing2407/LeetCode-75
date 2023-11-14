package RestoretheArrayFromAdjacentPairs_1743;

import java.util.*;

/**
 * @author Jing Hu
 * @date Jan 30 2021
 * 1. Iterate whole data pairs to generate a Map.
 * 2. The End point will show up once and the others have twice
 * 3. Looking for the end and use Map to find it's neighbour until to end
 */
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {

        int length = adjacentPairs.length;
        int[] restoreArray = new int[length + 1];
        ArrayList<Integer> restoreList = new ArrayList<>();

        // 1. Iterate whole data pairs to generate a Map.
        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
        generateMap(adjacentPairs, adjMap);

        // 2. Looking for the End point
        int end = 0;
        for (int key : adjMap.keySet()) {
            if (adjMap.get(key).size() == 1) {
                end = key;
                break;
            }
        }

        // 3. Use Map to find it's neighbour until to end
//        noRecursiveTraverse(length, restoreList, adjMap, end);
        HashSet<Integer> addedSet = new HashSet<>();
        dfsTraverse(adjMap, restoreList, addedSet, end);

        // 4. Transfer restoreList to restoreArray
        for (int i = 0; i < restoreList.size(); i++) {
            restoreArray[i] = restoreList.get(i);
        }

        return restoreArray;
    }

    private void dfsTraverse(HashMap<Integer, List<Integer>> adjMap, ArrayList<Integer> restoreList, HashSet<Integer> addedSet, int end) {
        restoreList.add(end);
        addedSet.add(end);
        List<Integer> pre = adjMap.get(end);
        for (int i = 0; i < pre.size(); i++) {
            if(!addedSet.contains(pre.get(i))){
                addedSet.add(pre.get(i));
                dfsTraverse(adjMap,restoreList,addedSet,pre.get(i));
            }
        }
    }

    private void noRecursiveTraverse(int length, LinkedList<Integer> restoreList, HashMap<Integer, List<Integer>> adjMap, int end) {
        restoreList.add(end);
        restoreList.add(adjMap.get(end).get(0));
        int preInt = end;
        int cur = adjMap.get(end).get(0);
        int count = 1;

        while (count < length) {
            if (preInt != adjMap.get(cur).get(0)) {
                restoreList.add(adjMap.get(cur).get(0));
                adjMap.remove(cur);
                count++;
                preInt = cur;
                cur = adjMap.get(cur).get(0);
                adjMap.remove(preInt);
            } else {
                restoreList.add(adjMap.get(cur).get(1));
                adjMap.remove(cur);
                count++;
                preInt = cur;
                cur = adjMap.get(cur).get(1);
                adjMap.remove(preInt);
            }
        }
    }

    private void generateMap(int[][] adjacentPairs, HashMap<Integer, List<Integer>> adjMap) {
        for (int[] x : adjacentPairs) {
            addToMap(adjMap, x[0], x[1]);
            addToMap(adjMap, x[1], x[0]);
        }
    }

    private void addToMap(HashMap<Integer, List<Integer>> adjMap, int key, int value) {
        if (adjMap.containsKey(key)) {
            adjMap.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            adjMap.put(key, list);
        }
    }
}
