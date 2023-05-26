package Math;

/**
 * @author Jing Hu
 * @date May 26 2023
 */
public class Base7_504 {
  public String convertToBase7(int num) {
    StringBuilder s = new StringBuilder();
    int n = num;
    if(num==0) return "0";
    if(num<0){
      n  *= -1;
    }

    while(n>0){
      s.append(n%7);
      n /= 7;
    }
    if(num<0){
      s.append("-");
    }
    return s.reverse().toString();
  }

  public static void main(String[] args) {
    Base7_504 base7_504 = new Base7_504();
    base7_504.convertToBase7(100);
  }
}
