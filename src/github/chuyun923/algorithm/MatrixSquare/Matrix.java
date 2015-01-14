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

    /**
     * 是否方阵
     * @return
     */
    public boolean isSquareMatrix() {
        return row == colum;
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

    //使用row和colum分割一个矩阵
    public Matrix[] splitMatrix(int row,int colum) {
        Matrix[] matrixes = new Matrix[4];
        //左上
        matrixes[0] = new Matrix(row,colum);
        for(int i=0;i<row;i++) {
            for(int j=0;j<colum;j++) {
                matrixes[0].setAt(getAt(i,j),i,j);
            }
        }
        //右上
        matrixes[1] = new Matrix(row,getColumsCount()-colum);
        for(int i=0;i<row;i++) {
            for(int j=colum;j<getColumsCount();j++) {
                matrixes[1].setAt(getAt(i,j),i,j-colum);
            }
        }

        //左下
        matrixes[2] = new Matrix(getRowsCount()-row,colum);
        for(int i=row;i<getRowsCount();i++) {
            for(int j=0;j<colum;j++) {
                matrixes[2].setAt(getAt(i,j),i-row,j);
            }
        }

        //右下
        matrixes[3] = new Matrix(getRowsCount()-row,getColumsCount()-colum);
        for(int i=row;i<getRowsCount();i++) {
            for(int j=colum;j<getColumsCount();j++) {
                matrixes[3].setAt(getAt(i,j),i-row,j-colum);
            }
        }
        return matrixes;
    }

    public static Matrix combineMatrix(Matrix[] matrixes) {
        Matrix result = new Matrix(matrixes[0].getRowsCount()+matrixes[3].getRowsCount(),matrixes[0].getColumsCount()+matrixes[3].getRowsCount());

        for(int i = 0;i<matrixes[0].getRowsCount();i++) {
            for(int j=0;j<matrixes[0].getColumsCount();j++) {
                result.setAt(matrixes[0].getAt(i,j),i,j);
            }
        }

        for(int i=0;i<matrixes[1].getRowsCount();i++) {
            for(int j=0;j<result.getColumsCount()-matrixes[1].getColumsCount();j++) {
                result.setAt(matrixes[1].getAt(i,j),i,j+matrixes[1].getColumsCount());
            }
        }

        for(int i=0;i<result.getRowsCount()-matrixes[2].getRowsCount();i++) {
            for(int j=0;j<matrixes[2].getColumsCount();j++) {
                result.setAt(matrixes[2].getAt(i,j),i+matrixes[2].getRowsCount(),j);
            }
        }

        for(int i=0;i<result.getRowsCount()-matrixes[3].getRowsCount();i++) {
            for(int j=0;j<result.getColumsCount()-matrixes[3].getColumsCount();j++) {
                result.setAt(matrixes[2].getAt(i,j),i+matrixes[3].getRowsCount(),j+matrixes[3].getColumsCount());
            }
        }

        return result;
    }

    public static Matrix add(Matrix matrix1,Matrix matrix2) {
        Matrix result = new Matrix(matrix1.getRowsCount(),matrix1.getColumsCount());
        for(int i=0;i<matrix1.getRowsCount();i++) {
            for(int j=0;j<matrix1.getColumsCount();j++) {
                result.setAt(matrix1.getAt(i,j)+matrix2.getAt(i,j),i,j);
            }
        }
        return result;
    }

}
