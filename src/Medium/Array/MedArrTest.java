package Medium.Array;

import Medium.Array.ProductofArrayExceptSelf238;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Jing Hu
 * @date Mar 13 2021
 */
public class MedArrTest {
    public static void main(String[] args) {
//        test11();
//        test238();
        test714();

    }

    private static void test714() {
        int[] prices = {4,5,5,2,4,3,5,5,2,3};
        Array.Stock714 s = new Array.Stock714();
        System.out.println(s.maxProfit(prices,3));
    }

    private static void test238() {
        ProductofArrayExceptSelf238 pae = new ProductofArrayExceptSelf238();
        int[] nums = {1, 2, 3, 4};
//        int[] nums={};
        int[] ints = pae.productExceptSelf(nums);
        for (int a : ints) {
            System.out.println(a + " ");
        }
    }

    private static void test11() {
        Array.ContainerWithMostWater11 cww = new Array.ContainerWithMostWater11();
        int[] nums = {};
        System.out.println(cww.maxArea(nums));
    }
}
