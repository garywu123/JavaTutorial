/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/24 21:24
 * @project JavaTutorial_2
 * @Description 创建一个泛型矩阵类，矩阵的运算，即使在不同元素下也是相同的。
 */
public abstract class GenericMatrix<E extends Number> {

    /**
     * 矩阵内元素的加减运算，因为元素不同加减运算也不同
     * 因此定义其为抽象方法
     * */
    protected abstract E add(E o1, E o2);

    protected abstract E multiply(E o1, E o2);

    protected abstract E zero();


    /**
     * 两个矩阵相加
     */
    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        // 只有两个矩阵形状相同才能相加
        if ((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length)) {
            throw new RuntimeException(
                    "两个矩阵的形状不对称。"
            );
        }

        E[][] result = (E[][]) new Number[matrix1.length][matrix1[0].length];

        // 执行相加操作
        for (int i =0;i<result.length;i++){
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    /**
     * 两个矩阵相乘
     */
    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        // 矩阵相乘，需要确保矩阵1的列数与矩阵2的行数相同
        if (matrix1[0].length != matrix2.length) {
            throw new RuntimeException("两个矩阵尺寸不相同，无法进行乘法操作");
        }

        E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = zero();

                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j],
                                       multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
    }

    public static void printResult(
            Number[][] m1,Number[][] m2,Number[][] m3, char op){
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.print(" " + m1[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print("   " + op + "   ");
            }else
                System.out.print("       ");

            for (int j = 0; j < m2.length; j++) {
                System.out.print(" " + m2[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print("  =  ");
            }else
                System.out.print("     ");

            for (int j = 0; j < m3.length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
