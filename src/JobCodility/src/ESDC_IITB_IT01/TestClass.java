package ESDC_IITB_IT01;

import jdk.jshell.execution.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class TestClass {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int N = Integer.parseInt(br.readLine().trim());
//        String S = br.readLine();
//        String[] comments = new String[N];
//        for (int i = 0; i < N; i++) {
//            comments[i] = br.readLine();
//        }
//
//        int out_ = solution(N, S, comments);
//        System.out.println(out_);
//
//        wr.close();
//        br.close();
        String comments[] = {"is_BAD","bad_bad_bad"};
        int res = solution(2,"bad",comments);
        System.out.println(res);

    }
    static int solution(int N, String S, String[] comments){
        // Write your code here
        if (N == 0 || S.length() == 0 )  return 0;

        int result = 0;
        for (int i = 0; i < N; i++) {
            String curr = comments[i];
            int currLength = curr.length();
            int Slength = S.length();
            for (int j = 0; j < currLength-Slength+1; j++) {

                if(curr.substring(j,Slength+j).equalsIgnoreCase(S)) {
                    result++;
                    break;
                }
            }
        }

        return result;

    }
}
