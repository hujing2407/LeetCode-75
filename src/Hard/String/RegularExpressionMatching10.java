package Hard.String;

/**
 * @author Jing Hu
 * @date Dec. 13 2023
 */
public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int j = 1; j < n + 1; j++)
            if (p.charAt(j-1) == '*') f[0][j] = f[0][j-2];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    f[i][j] = f[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        f[i][j] = f[i][j-2] || f[i-1][j-2] || f[i-1][j];
                    else f[i][j] = f[i][j-2];
                }
            }
        }
        return f[m][n];
    }
}
