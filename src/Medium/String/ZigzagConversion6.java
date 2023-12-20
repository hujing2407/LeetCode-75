package Medium.String;

/**
 * @author Jing Hu
 * @date Dec. 18 2023
 */
public class ZigzagConversion6 {
    public static String convert(String s, int numRows) {

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        int idx = 0;
        while (idx < s.length()) {
            for (int line = 0; line < numRows && idx < s.length(); line++)
                sbs[line].append(s.charAt(idx++));
            for (int line = numRows - 2; line > 0 && idx < s.length(); line--)
                sbs[line].append(s.charAt(idx++));
        }
        for (int k = 1; k < numRows; k++)
            sbs[0].append(sbs[k]);

        return sbs[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
