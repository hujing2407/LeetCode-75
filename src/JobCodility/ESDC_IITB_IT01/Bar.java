package ESDC_IITB_IT01;

/**
 * @author Jing Hu
 * @date Apr. 13 2023
 */
public class Bar implements Foo{

    String name ="Bar";

    public void print() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Foo foo = new Bar();
        foo.print();
    }
}
