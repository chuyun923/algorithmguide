package github.chuyun923.algorithm.MatrixSquare;

/**
 * Created by pengliang on 15-1-13.
 *
 * 计算矩阵的乘积
 *
 * 直接使用矩阵的定义来做
 * 时间复杂度 O(n^3)
 */
public class NormalAlgorithm {

    public static Matrix matrixSquare(Matrix matrix1,Matrix matrix2) {
        //矩阵相乘的条件   第一个矩阵的列数和第二个矩阵的行数相等
        if(matrix1.getColumsCount() != matrix2.getRowsCount()) {
            throw new IllegalStateException("矩阵不能相乘");
        }

        Matrix result = new Matrix(matrix1.getRowsCount(),matrix2.getColumsCount());

        //最外层循环取出第一个矩阵的每一行
        for(int i = 0;i<matrix1.getRowsCount();i++) {
            //第二层取出第二个矩阵中的每一列
            for(int j =0;j<matrix2.getColumsCount();j++) {
                //第三层循环做乘积
                int tmp = 0;
                for(int k=0;k<matrix1.getColumsCount();k++) {
                    tmp += matrix1.getAt(i,k)*matrix2.getAt(k,j);
                }
                result.setAt(tmp,i,j);
            }
        }

        return result;
    }
}
