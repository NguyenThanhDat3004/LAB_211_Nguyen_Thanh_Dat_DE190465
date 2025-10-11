package tuan_2.matrix.model;

public class MatrixManagement {
    private Matrix matrix1, matrix2, result;
    public MatrixManagement() {
        matrix1 = new Matrix();
        matrix2 = new Matrix();
        result = new Matrix();
    }
    // get set
    public Matrix getMatrix1() {
        return matrix1;
    }
    public Matrix getMatrix2() {
        return matrix2;
    }
    public Matrix getResult() {
        return result;
    }
    public void setMatrix1(Matrix matrix1) {
        this.matrix1 = matrix1;
    }
    public void setMatrix2(Matrix matrix2) {
        this.matrix2 = matrix2;
    }
    public void setResult(Matrix result) {
        this.result = result;
    }
    // cong 2 ma tran
    public Matrix add() {
        if (matrix1.getRow() != matrix2.getRow() || matrix1.getCol() != matrix2.getCol()) {
            return null;
        } // cung kich thuoc moi cong duoc
        int r = matrix1.getRow();
        int c = matrix1.getCol();
        result.setSize(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.getData()[i][j] = matrix1.getData()[i][j] + matrix2.getData()[i][j];
            }
        }
        return result;
    }
    // tru 2 ma tran
    public Matrix subtract() {
        if (matrix1.getRow() != matrix2.getRow() || matrix1.getCol() != matrix2.getCol()) {
            return null;
        } // cung kich thuoc moi tru duoc
        int r = matrix1.getRow();
        int c = matrix1.getCol();
        result.setSize(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.getData()[i][j] = matrix1.getData()[i][j] - matrix2.getData()[i][j];
            }
        }
        return result;
    }
    // nhan 2 ma tran
    public Matrix multiply() {
        if (matrix1.getCol() != matrix2.getRow()) {
            return null;
        } // so cot ma tran 1 phai bang so hang ma tran 2
        int r = matrix1.getRow();
        int c = matrix2.getCol();
        int k = matrix1.getCol(); // hoac matrix2.getRow()
        result.setSize(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.getData()[i][j] = 0;
                for (int t = 0; t < k; t++) {
                    result.getData()[i][j] += matrix1.getData()[i][t] * matrix2.getData()[t][j];
                }
            }
        }
        return result;
    }


    

}
