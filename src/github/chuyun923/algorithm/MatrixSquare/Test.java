package github.chuyun923.algorithm.MatrixSquare;


import java.util.Random;

/**
 * Created by pengliang on 15-1-7.
 */
class Test {
    public static void main(String args[]) {

        Random random = new Random();
        Matrix matrix1 = new Matrix(2,2);
        Matrix matrix2 = new Matrix(2,2);
        for(int i=0;i< matrix1.getRowsCount();i++) {
            for(int j=0;j<matrix1.getColumsCount();j++) {
                matrix1.setAt(random.nextInt(10),i,j);
            }
        }

        for(int i=0;i< matrix2.getRowsCount();i++) {
            for(int j=0;j<matrix2.getColumsCount();j++) {
                matrix2.setAt(random.nextInt(10),i,j);
            }
        }

        matrix1.printInfo();
        matrix2.printInfo();
        MultiRecursive.multiRecursive(matrix1,matrix2).printInfo();

    }


}
