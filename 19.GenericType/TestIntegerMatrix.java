public class TestIntegerMatrix {

    public static void main(String[] args) {
        // 创建两个整数数组
        Integer[][] matrix1 = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Integer[][] matrix2 = new Integer[][]{{1, 1, 1}, {2, 2, 2}, {0, 0, 0}};

        // 创建整数矩阵
        GenericMatrix integerMatrix = new IntegerMatrix();

        System.out.println("m1 + m2 is ");
        integerMatrix.printResult(matrix1,
                                  matrix2,
                                  integerMatrix.addMatrix(matrix1, matrix2),
                                  '+');

        System.out.println("m1 * m2 is ");
        integerMatrix.printResult(matrix1,
                                  matrix2,
                                  integerMatrix.multiplyMatrix(matrix1, matrix2),
                                  '*');
    }
}
