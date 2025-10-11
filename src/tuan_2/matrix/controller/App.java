package tuan_2.matrix.controller;

import tuan_2.matrix.view.Menu1;
import tuan_2.matrix.view.Solution;
import tuan_2.matrix.model.Matrix;
import tuan_2.matrix.model.MatrixManagement;
import tuan_2.matrix.utils.Validator;

public class App extends Menu1 {
    private MatrixManagement manager = new MatrixManagement();
    private Solution sol = new Solution();
    public App() {
        super("Matrix Management", new String[]{
            "Add Matrix",
            "Subtract Matrix",
            "Multiply Matrix",
            "Exit"
        });
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                this.setMatrix(manager);
                if(manager.add()==null){
                    System.out.println("Error: Matrices must have the same dimensions for addition.");
                }else{
                    sol.printOperation("Add Matrix", "+", manager.getMatrix1(), manager.getMatrix2(), manager.getResult());
                }
                break;
            case 2:
                this.setMatrix(manager);
                if(manager.subtract()==null){
                    System.out.println("Error: Matrices must have the same dimensions for subtraction.");
                }else{
                sol.printOperation("Subtract Matrix", "-", manager.getMatrix1(), manager.getMatrix2(), manager.getResult());
                }
                break;
            case 3:
                this.setMatrix(manager);
                if(manager.multiply()==null){
                    System.out.println("Error: Number of columns in Matrix 1 must equal number of rows in Matrix 2 for multiplication.");
                }else{
                sol.printOperation("Multiply Matrix", "*", manager.getMatrix1(), manager.getMatrix2(), manager.getResult());
                }
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid selection. Exiting...");
        }    
    }
    // ham nhap du lieu cho ma tran
    public Matrix inputMatrix(){
        int r = Validator.checkNum("Enter number of rows: ");
        int col = Validator.checkNum("Enter number of columns: ");
        Matrix m = new Matrix(r, col);
        for(int i=0; i<r; i++){
            for(int j=0; j<col; j++){
                m.getData()[i][j] = Validator.checkElement("Enter element ["+(i+1)+"]["+(j+1)+"]: ");
            }
        }
        return m;
    }
    // cai dat matrix
    public void setMatrix(MatrixManagement manager) {
        System.out.println("Input Matrix 1:");
        manager.setMatrix1(this.inputMatrix());
        System.out.println("Input Matrix 2:");
        manager.setMatrix2(this.inputMatrix());
    }
    //
    
   // main
   public static void main(String[] args) {
        App app = new App();
        app.run();
   }
    
} 
