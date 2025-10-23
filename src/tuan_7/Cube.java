package tuan_7;

public class Cube extends ThreeDimensionalShape{
    private double side; // do dai canh
    // Constructor
    public Cube(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return 6 * side * side;
    }
    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
    @Override
    public String getResult() {
        return "Cube:\n" +
                " Side: " + side + "\n" +
                " Surface Area: " + this.getArea() + "\n" +
                " Volume: " + this.getVolume();
    }
}
