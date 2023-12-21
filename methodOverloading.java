

import java.util.Scanner;

public class methodOverloading {
		public static void main(String [] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Base of the Triangle:");
			float base=sc.nextFloat();
			System.out.println("Enter the Height of the Triangle:");
			float breadth=sc.nextFloat();
			System.out.println("Enter the Width of the Rectangle");
			int width=sc.nextInt();
			System.out.println("Enter the Height of the Rectangle");
			int height=sc.nextInt();
			System.out.println("Enter the Radius of the Circle");
			float radius=sc.nextFloat();
			Shape shapes = new Shape();
			shapes.area(breadth,base);
			shapes.area(width,height);
			shapes.area(radius);
			
		}
		}
		class Shape {
			int area;
			public void area(float base, float breadth ) {
				
				System.out.println("The area of Triangle "+(base*breadth)/2);
			}
			public void area(int width, int height) 
			{
				 
				System.out.println("The area of Rectangle "+height*width);
			}
		    public void area(float radius)
		    {	    	
		    	System.out.println("The area of Circle "+3.14*radius*radius);
		    }
		}
		