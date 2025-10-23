package tuan_7;

public class Sphere extends ThreeDimensionalShape{
    private double radius; // bán kính

    // Constructor
    public Sphere(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }
    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
    @Override
    public String getResult() {
        return "Sphere:\n" +
                " Radius: " + radius + "\n" +
                " Surface Area: " + this.getArea() + "\n" +
                " Volume: " + this.getVolume();
    }
}
