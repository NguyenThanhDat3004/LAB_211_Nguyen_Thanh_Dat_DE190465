package tuan_2.matrix.model;

public class Matrix {
    private int row, col;
    private double[][] data;

    public Matrix() {
        row = col = 0;
        data = null;
    }
    public Matrix(int r, int c) {
        row = r;
        col = c;
        data = new double[r][c];
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public double[][] getData() {
        return data;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setData(double[][] data) {
        this.data = data;
    }
    // ham cap phat lai mang, khi kich thuoc thay doi
    public void setSize(int row, int col) {
    this.row = row;
    this.col = col;
    this.data = new double[row][col];
    }

}
