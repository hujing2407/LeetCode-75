package Map.String;

/**
 * Runtime
 * 2 ms
 * Beats
 * 46.15%
 *
 * Memory
 * 43 MB
 * Beats
 * 5.62%
 *
 * @author Jing Hu
 * @date Apr. 14 2023
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int posA = a.length() - 1;
        int posB = b.length() - 1;

        while(posA>=0 || posB >=0 || carry >0){
            if (posA >= 0 ) {
                carry += a.charAt(posA) - '0';
            }
            if (posB >= 0 ) {
                carry += b.charAt(posB) - '0';
            }
            res.append(carry % 2);
            carry /= 2;
            posA--;
            posB--;
        }

        return res.reverse().toString();
    }


    /*public String addBinaryFisrtTry(String a, String b) {

        boolean carry = false;
        int posA = a.length() - 1;
        int posB = b.length() - 1;
        String remain = null;
        int newLen = Math.max(posA, posB) + 1;

        if (posA > posB) {
            remain = a;
        } else if (posA < posB) {
            remain = b;
        }
        char res[] = new char[newLen];

        while (posB >= 0 && posA >= 0) {
            newLen--;

            if (a.charAt(posA) == '1' && b.charAt(posB) == '1') {
                if (carry) {
                    res[newLen] = '1';
                } else {
                    res[newLen] = '0';
                }
                carry = true;
            } else if (a.charAt(posA) == '1' || b.charAt(posB) == '1') {
                if (carry) {
                    res[newLen] = '0';
                    carry = true;
                } else {
                    res[newLen] = '1';
                    carry = false;
                }
            } else {
                if (carry) {
                    res[newLen] = '1';
                } else {
                    res[newLen] = '0';
                }
                carry = false;
            }

            posB--;
            posA--;
        }

        if (remain != null) {

            int pos = Math.max(posA, posB);
            // Higher bit
            while (pos >= 0) {
                newLen--;
                if (remain.charAt(pos) == '1' && carry) {
                    res[newLen] = '0';
                } else if (remain.charAt(pos) == '0' && carry) {
                    res[newLen] = '1';
                    carry = false;
                } else {
                    res[newLen] = remain.charAt(pos);
                    carry = false;
                }
                pos--;
            }
        }

        if (carry) {
            return "1" + new String(res);
        } else {
            return new String(res);
        }

    }*/
}
