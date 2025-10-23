package tuan_7;

public class App {
    public static void main(String[] args) {
        while(true){
            System.out.println("MENU \n" +
                    "1. Circle \n"+
                    "2.Square \n"+
                    "3.Triangle \n"+
                    "4.Sphere \n"+
                    "5. Cube\n"+
                    "6.Tetrahedron");
            int choice = Validator.checkChoice("Enter your choice");
            switch (choice){
                case 1:
                    double radius = Validator.checkNum("Enter radius: ");
                    Circle c = new Circle(radius);
                    System.out.println(c.getResult());
                    break;
                case 2:
                    double side = Validator.checkNum("Enter side: ");
                    Square s = new Square(side);
                    System.out.println(s.getResult());
                    break;
                case 3:
                    double a = Validator.checkNum("Enter side A: ");
                    double b = Validator.checkNum("Enter side B: ");
                    double c1 = Validator.checkNum("Enter side C: ");
                    Triangle t = new Triangle(a,b,c1);
                    if(!t.isValidTriangle()){
                        System.out.println("Not a triangle");
                        continue;
                    }
                    System.out.println(t.getResult());
                    break;
                case 4:
                    double ra = Validator.checkNum("Enter radius: ");
                    Sphere sp = new Sphere(ra);
                    System.out.println(sp.getResult());
                    break;
                case 5:
                    double d = Validator.checkNum("Enter side: ");
                    Cube cu =  new Cube(d);
                    System.out.println(cu.getResult());
                    break;
                case 6:
                    double edge = Validator.checkNum("Enter edge: ");
                    Tetrahedron te = new Tetrahedron(edge);
                    System.out.println(te.getResult());
                    break;
            }
        }

    }
}
