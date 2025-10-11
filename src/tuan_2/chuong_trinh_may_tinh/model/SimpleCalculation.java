package tuan_2.chuong_trinh_may_tinh.model;

public class SimpleCalculation {
    private double memory;
    private Operator operator;
    private double input;
    // constructor

    public SimpleCalculation() {
        this.memory = 0;
        this.operator = Operator.EQUAL;
    }

    public double getMemory() {
        return memory;
    }
    public void setMemory(double memory) {
        this.memory = memory;
    }
    public Operator getOperator() {
        return operator;
    }
    public void setOperator(Operator operator) {
        this.operator = operator;
    }
    public void setInput(double input) {
        this.input = input;
    }
    public double getInput() {
        return input;
    }
    // kiem tra dau bang 
    public boolean isEqual() {
        return this.operator == Operator.EQUAL;
    }
    //tinh toan don gian
    public double performSimpleCalculation() {
        switch (operator) {
            case ADD:
                memory += input;
                break;
            case SUBTRACT:
                memory -= input;
                break;
            case MULTIPLY:
                memory *= input;
                break;
            case DIVIDE:
                if (input != 0) {
                    memory /= input;
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;
            case EXPONENT:
                memory = Math.pow(memory, input);
                break;
            default:
                System.out.println("Invalid operator. Exiting...");
                break;
        }
        return memory;
    }

}
