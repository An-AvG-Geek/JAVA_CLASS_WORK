package Employee1;
import java.util.*;
public class AbstractClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();
		Hexagon hexagon = new Hexagon();
        rectangle.numberOfSides();
        triangle.numberOfSides();
        hexagon.numberOfSides();

	}

}

abstract class Shapes{
	abstract public void numberOfSides();		

}
class Rectangle extends Shapes{
	public void numberOfSides() {
		System.out.println("rectangle has 4 sides");
	}
}

class Triangle extends Shapes{

public void numberOfSides() {

 System.out.println("triangle has 3 sides");

}
}

class Hexagon extends Shapes{
	public void numberOfSides() {
		System.out.println("Hexagon has 6 sides");

	}
}


