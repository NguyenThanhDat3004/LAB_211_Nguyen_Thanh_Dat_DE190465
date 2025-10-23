package tuan_7;

public class Triangle extends TwoDimensionalShape{
    private double a; // canh 1
    private double b; // canh 2
    private double c; // canh 3

    // Constructor
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    // check
    public boolean isValidTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    // tinh bang Heron
    @Override
    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    @Override
    public String getResult() {
        return "Triangle:\n" +
                " Side A: " + a + "\n" +
                " Side B: " + b + "\n" +
                " Side C: " + c + "\n" +
                " Area : " +this.getArea();
    }
}
