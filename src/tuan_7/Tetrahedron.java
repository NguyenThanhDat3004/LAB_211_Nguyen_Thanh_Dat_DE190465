package tuan_7;

public class Tetrahedron extends ThreeDimensionalShape{
    private double edge; // do dai canh
    // Constructor
    public Tetrahedron(double edge) {
        this.edge = edge;
    }
    @Override
    public double getArea() {
        return Math.sqrt(3) * edge * edge;
    }
    @Override
    public double getVolume() {
        return (Math.pow(edge, 3)) / (6 * Math.sqrt(2));
    }
    @Override
    public String getResult() {
        return "Tetrahedron:\n" +
                " Edge: " + edge + "\n" +
                " Surface Area: " + this.getArea() + "\n" +
                " Volume: " + this.getVolume();
    }
}
