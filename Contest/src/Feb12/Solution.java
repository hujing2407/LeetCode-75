package Feb12;

import java.util.LinkedList;

/**
 * @author Jing Hu
 * @date Feb 12 2021
 */
public class Solution {
    public int numberOfSteps(int num) {
        int step = 0;
        while (true) {
            if (num == 1) {
                return ++step;
            } else if (num == 0) return step;
            if ((num & 1) == 1) {
                step += 2;
            } else {
                step++;
            }
            num = num >>> 1;
        }

    }


    public int numSteps1(String s) {
        char[] chars = s.toCharArray();
        int step = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int a : chars             ) {
            list.addFirst(a-48);
        }

        while (list.size()>1) {

            if (list.get(0) == 1) {
                int i =1;
                while(i<list.size() && list.get(i)!=0){
                    list.set(i,0) ;
                    i++;
                }

                if (i<list.size()) {
                    list.set(i,1);
                }else {
                    list.add(1);
                }
                list.remove(0);
                step += 2;
            } else {
                list.remove(0);
                step++;
            }
        }
        return step;
    }

    public int numSteps(String s) {
        int step = 0;
        int carry = 0;
        for (int i = s.length()-1; i > 0 ; i--) {
            if(s.charAt(i) + carry -'0' == 1){
                carry = 1;
                step += 2;
            }else if(s.charAt(i) + carry -'0' == 2){
                carry = 1;
                step ++;
            } else{
                step ++;
            }
        }

       return step+carry;
    }
}