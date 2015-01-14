package github.chuyun923.algorithm.MatrixSquare;

/**
 * Created by pengliang on 15-1-13.
 *
 * 直接递归算法
 */
public class MultiRecursive {


    /**
     * 普通递归
     * @param matrix1
     * @param matrix2

     * @return
     */
    public static Matrix multiRecursive(Matrix matrix1,Matrix matrix2) {
        Matrix result = new Matrix(matrix1.getRowsCount(),matrix1.getColumsCount());
        if(matrix1.getRowsCount()==1) {
            result.setAt(matrix1.getAt(0,0)*matrix2.getAt(0,0),0,0);
            return result;
        }

        int row = matrix1.getRowsCount()/2;
        int colum = matrix1.getColumsCount()/2;

        Matrix[] matrixes1 = matrix1.splitMatrix(row,colum);
        Matrix[] matrixes2 = matrix2.splitMatrix(row,colum);

        Matrix A11 = Matrix.add(multiRecursive(matrixes1[0],matrixes2[0]),multiRecursive(matrixes1[1],matrixes2[2]));
        Matrix A12 = Matrix.add(multiRecursive(matrixes1[0],matrixes2[1]),multiRecursive(matrixes1[1],matrixes2[3]));
        Matrix A21 = Matrix.add(multiRecursive(matrixes1[2],matrixes2[0]),multiRecursive(matrixes1[3],matrixes2[2]));
        Matrix A22 = Matrix.add(multiRecursive(matrixes1[2],matrixes2[1]),multiRecursive(matrixes1[3],matrixes2[3]));
        return Matrix.combineMatrix(new Matrix[]{A11,A12,A21,A22});

    }

    static class MatrixDivider {
        int left,top,right,bottom;

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }
}
