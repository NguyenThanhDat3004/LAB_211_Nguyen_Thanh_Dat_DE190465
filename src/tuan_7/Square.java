package tuan_7;

public class Square extends TwoDimensionalShape{
    private double side; // do dai canh
    // Constructor
    public Square(double side) {
        this.side = side;
    }
    // dien tich
    @Override
    public double getArea() {
        return side * side;
    }
    @Override
    public String getResult() {
        return "Square:\n" +
                " Side: " + side + "\n" +
                " Area: " + this.getArea();
    }
}
