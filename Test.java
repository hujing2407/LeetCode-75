import Level_2.SpiralMatrix;

public class Test {
    public static void main(String[] args) {
        /*  
        int[] prices = {7,1,5,3,6,4};
        BestTimetoBuySellStock bs = new BestTimetoBuySellStock();
        System.out.println(bs.maxProfit(prices));
      

        String a = "cbaebabacd";
        String b = "bca";
        FindAllAnagramsString f = new FindAllAnagramsString();
        System.out.println(f.findAnagrams(a, b));
          

          int a = 18;
          HappyNumber hm = new HappyNumber();
          System.out.println(hm.isHappy(a));
        */

      int[][]  matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
      SpiralMatrix sm = new SpiralMatrix();
      System.out.println(sm.spiralOrder(matrix));

    }
}
