package Array;

/**
 * @author Jing Hu
 * @date Mar 14 2021
 */
public class A {
    int x;
    public A(int y){
        int x = y;
    }
    public void aMethod(){ // need "void" modifier
        System.out.println(x); // 0
    }
}
