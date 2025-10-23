package tuan_7;

public abstract class ThreeDimensionalShape implements Shape{
    public abstract double getArea();
    public abstract double getVolume();

    @Override
    public String getResult() {
        return super.toString();
    }
}
