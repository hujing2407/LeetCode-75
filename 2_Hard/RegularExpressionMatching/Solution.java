package RegularExpressionMatching;

/**
 * @author Jing Hu
 * @date Jan 27 2021
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int slength = s.length();
        int plength = p.length();
        int sIndex = 0;
        int pIndex = 0;
        boolean flag = false;

        // remove a* is not in s string patten
        char[] pshort = new char[plength];
        String a = "";
        for (int i = 0; i < plength; i++) {
            int indexOf = s.indexOf(pc[i]);
            if ('.' != pc[i] && indexOf == -1 && i < plength - 1 && '*' == pc[i + 1]) {
                i++;
            } else {
                a = a + pc[i];
            }
        }
        char[] pshorts = a.toCharArray();
        pc = pshorts;
        plength = pshorts.length;

        // shorter a*a to a*


        while (sIndex < slength && pIndex < plength) {
            if ('.' == pc[pIndex]) {
                if (pIndex == plength - 2 && '*' == pc[pIndex + 1]) {
                    flag = true;
                    break;
                } else if (pIndex < plength - 1 && '*' == pc[pIndex + 1]) {
                    String subP = p.substring(pIndex + 2);
                    String temp = s.substring(sIndex);
                    int subIndex = temp.indexOf(pc[pIndex + 2]);
                    if (subIndex == -1) {
                        break;
                    }
                    String subS = temp.substring(subIndex);
                    flag = isMatch(subS, subP);
                    break;
                } else {
                    sIndex++;
                    pIndex++;
                }
            } else if ('*' == pc[pIndex]) {
                while (sIndex < slength && (sc[sIndex - 1] == sc[sIndex])) {
                    sIndex++;
                }
                char pre = pc[pIndex - 1];

                do {
                    pIndex++;
                } while (pIndex < plength && pre == pc[pIndex]);


            } else {
                if (sc[sIndex] == pc[pIndex]) {
                    if (pIndex < plength-2 && pc[pIndex + 1] == '*' && pc[pIndex + 2] == pc[pIndex]){
                        char current = sc[sIndex];
                        while (sIndex < slength && (current == sc[sIndex])) {
                            sIndex++;
                        }
                        pIndex += 3;
                    }else{
                        sIndex++;
                        pIndex++;
                    }
                } else if (pIndex < plength && pc[pIndex + 1] == '*') {
                    pIndex += 2;
                } else {
                    return false;
                }
            }
        }

        if (sIndex == slength && pIndex == plength) flag = true;

        return flag;
    }
}
