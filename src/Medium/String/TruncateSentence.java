package Medium.String;

/**
 * @author Jing Hu
 * @date Apr 03 2021
 */
public class TruncateSentence {
    public String truncateSentence(String s, int k) {
        if(k==0) return null;
        String s1 = "";
        while(--k>0){
            int i = s.indexOf(' ');
            s1 += s.substring(0,i) + " ";
            s=s.substring(i+1);

        }
        int i = s.indexOf(' ');
        if(i != -1){
            s1 += s.substring(0,i);
            s=s.substring(i+1);
        }else{
            s1 = s1 + s;
        }
        return s1;
    }
}
