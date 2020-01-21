/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/18 21:11
 * @project JavaTutorial_2
 * @Description
 */
public class TestRationalClass {

    public static void main(String[] args) {
        Rational rational1 = new Rational(3, 9);
        Rational rational2 = new Rational(4, 102);

        System.out.println("第一个数为：" + rational1);
        System.out.println("第二个数为：" + rational2);
        System.out.println(rational1 + " + " + rational2 + " = " + rational1.add(rational2));
        System.out.println(rational1 + " - " + rational2 + " = " + rational1.subtract(rational2));
        System.out.println(rational1 + " * " + rational2 + " = " + rational1.multiply(rational2));
        System.out.println(rational1 + " / " + rational2 + " = " + rational1.divide(rational2));
        System.out.println(rational1 + " > " + rational2+ " = " + rational1.compareTo(rational2));;
    }
}
