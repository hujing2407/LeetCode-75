package Topics.SlidingWindow.JobCodility.AgilityPR;

/**
 * @author Jing Hu
 * @date May 13 2022
 */
public class Solution {
//    public int solution(int[] A) {
//        // write your code in Java SE 8
//
//        int sum = -1;
//
//        int i =0;
//        while (i < A.length) {
//            if(A[i]<0){
//                i++;
//                if(i == A.length) break;
//                continue;
//            }
//
//            int subSum = 0;
//            while(i<A.length && A[i]>=0){
//                subSum += A[i];
//                i++;
//            }
//            if(subSum > sum){
//                sum = subSum;
//            }
//            i++;
//        }
//
//        return sum;
//    }


//    public int solution(int N) {
//        // write your code in Java SE 8
//
//        int size = 20; // 20 is enough for first 200 number
//        int[] result = new int[200];
//        List<LinkedList<Integer>> lists = new LinkedList<LinkedList<Integer>>();
//        for (int i = 0; i < size; i++) {
//            LinkedList<Integer> integers = new LinkedList<>();
//            for (int j = 0; j < size; j++) {
//                integers.add((int)(Math.pow(2,i) * Math.pow(3,j)));
//            }
//            lists.add(integers);
//        }
//
//        for (int i = 0; i < 200; i++) {
//            int max = Integer.MAX_VALUE;
//            int index = 0;
//            for (int j = 0; j < size; j++) {
//                if (max > lists.get(j).get(0)){
//                    max = lists.get(j).get(0);
//                    index = j;
//                }
//            }
//            result[i] = max;
//            lists.get(index).remove(0);
//        }
//
//        return result[N];
//    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 0) return 0;

        if(A.length == 1) return 1;

        int len, maxLen=0;
        int index  = 0;
        while (index < A.length){
            len = 1; // set a default value
            int odd = A[index];
            if(index+1 == A.length) break;

            int even = A[index+1];
            while (index + 2 < A.length) {
                if (odd == A[index+2] && even == A[index+1]){
                    len +=2;
                    index +=2;
                    continue;
                }if(odd == A[index+2] && even != A[index+1]){
                    len++;
                    break;
                }
                index++;
            }

            if(len>maxLen) maxLen = len;
            index +=len;
        }


        return maxLen;

    }

}
