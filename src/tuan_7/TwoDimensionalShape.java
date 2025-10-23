package tuan_7;

public abstract class TwoDimensionalShape implements Shape {
    public abstract double getArea();

    @Override
    public String getResult() {
        return super.toString();
    }
}
