/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/18 21:11
 * @project JavaTutorial_2
 * @Description 程序清单13-13 自己设计一个有理数类，也就是分数类
 */
public class Rational extends Number implements Comparable<Rational> {

    // 定义两个数据域，分别用于显示被除数和除数
    private long numerator = 0;
    private long denominator = 1;

    public Rational(){
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator); // 计算两个数的最大公约数
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    /** 查找公约数 */
    private static long gcd(long numerator, long denominator) {
        long number1 = Math.abs(numerator);
        long number2 = Math.abs(denominator);
        int gcd = 1;

        for (int k = 1; k <= number1 && k <= number2; k++) {
            if (number1 % k == 0 && number2 % k == 0) {
                gcd = k;
            }
        }
        return gcd;
    }

    /**
     * 分数相加
     */
    public Rational add (Rational secondRational) {
        // 分子 = 第一个数的分子 * 第二个数的分母 + 第二个数的分子 * 第一个数的分母
        long n = numerator * secondRational.getDenominator() +
                denominator * secondRational.getNumerator();
        // 分母 = 第一个数的分母 * 第二个数的分母
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    /**
     * 分数相减
     */
    public Rational subtract(Rational secondRational) {
        long n = numerator * secondRational.getDenominator() -
                denominator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    public Rational multiply(Rational secondRational) {
        long n = numerator * secondRational.getNumerator();
        long d = denominator * secondRational.getDenominator();
        return new Rational(n, d);
    }

    public Rational divide(Rational secondRational) {
        long n = numerator * secondRational.getDenominator();
        long d = numerator * secondRational.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return numerator + " ";
        }else
            return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        // 如果两个数相减为0，则相等
        if ((this.subtract((Rational) obj)).getNumerator() == 0) {
            return true;
        }
        else
            return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return numerator * 1.0 / denominator;
    }

    @Override
    public int compareTo(Rational rational) {
        if (this.subtract(rational).getNumerator() > 0) {
            return 1;
        }
        else if (this.subtract(rational).getNumerator() < 0) {
            return -1;
        }else
            return 0;
    }

    /**
     * 下面是 数据域的 get 和 set 方法
     * */
    public long getNumerator() {
        return numerator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }
}
