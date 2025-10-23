package tuan_7;

public class Circle extends TwoDimensionalShape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String getResult() {
        return "Circle: \n Radius: "+radius+"\n Area: "+this.getArea();
    }
}
