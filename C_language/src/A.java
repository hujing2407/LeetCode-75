import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Jing Hu
 * @date Mar 21 2021
 */
public class A {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("payables.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        double v = in.nextDouble();
        System.out.println(v);
    }
}
