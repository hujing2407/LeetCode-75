package JobCodility.AgilityPR;

/**
 * @author Jing Hu
 * @date May 13 2022
 */
public class Test {
    public static void main(String[] args) {
//        int[] a = {1,2,-3,4,5,-6};
//        int[] a = {-8,3,0,5,-3,12};
//        int[] a = {-1,-2,-3,-4,-5,-6};
//        int[] A = {-1,2,1,2,0,2,1,-3,4,3,0,-1};
//        int[] A = {7,-5,-5,-5,7,-1,7};
        int[] A = {7,4,-2,4,-2,7,-1,7};

//        Solution s = new Solution();
//
//        System.out.println(s.solution(15));

        int result = (new Solution()).solution ( A );
//
        System.out.println(result);


    }
}
