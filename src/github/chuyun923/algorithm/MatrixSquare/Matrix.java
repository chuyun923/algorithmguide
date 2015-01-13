package github.chuyun923.algorithm.MatrixSquare;

/**
 * Created by pengliang on 15-1-13.
 *
 * 矩阵对象
 */
public class Matrix {
    private int[][] matrix;
    private int row,colum;

    //指定n为行数，m为列数
    public Matrix(int n,int m) {
        this.row = n;
        this.colum = m;
        matrix = new int[n][m];
    }

    //方阵
    public Matrix(int n) {
       matrix = new int[n][n];
    }

    //获取C n,m元素
    public int getAt(int n,int m) {
        return matrix[n][m];
    }

    public void setAt(int value,int n,int m) {
        matrix[n][m] = value;
    }

    public int getRowsCount() {
        return row;
    }

    public int getColumsCount() {
        return colum;
    }

    public void printInfo() {
        for(int i=0;i<row;i++) {
            for(int j=0;j<colum;j++) {
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.print("\n");
        }

        System.out.print("--------------------------------------------\n");

    }

}
