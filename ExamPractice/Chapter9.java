package ExamPractice;

public class Chapter9 
{
	public static void main(String[] args)
	{
		/*
		 * Write Java statements for the following tasks:
			a. Declare an instance mySphere of Sphere with a radius 2.
			b. Declare an instance myBall of Ball whose radius is 6 and whose name is
			Beach ball.
			c. Display the diameters of mySphere and myBall. 
		 */
		Sphere mySphere = new Sphere(2);
		Ball myBall = new Ball("Beach Ball", 6);
		mySphere.displayStatistics();
		myBall.displayStatistics();
	}
}

class Sphere 
{
	private double radius;

	public Sphere(double r) 
	{ radius = r; } 
	
	public void setRadius(double newRadius) 
	{
		if (newRadius >= 0.0) 
			radius = newRadius;
	}

	public double getRadius()
	{ return radius; } 

	public double diameter()
	{ return 2.0 * radius; } 

	public double circumference() 
	{ return Math.PI *diameter(); } 
	
	public double area() 
	{ return 4.0 * Math.PI * radius * radius; }
	
	public double volume() 
	{ return (4.0 * Math.PI * Math.pow(radius, 3.0)) / 3.0; } // end volume

	public void displayStatistics() 
	{
		System.out.println("\nRadius = "+ getRadius() + "\nDiameter ="+diameter() + "\nCircumference = "+circumference() +
				            "\nArea = " +area() + "\nVolume = " +volume() +"\n");
	}
	
	
}

class Ball extends Sphere 
{
	private String name;
	
	public Ball(String n, double r)
	{
		super(r);
		name = n;
	}
	
	public String getName()
	{ return name; }
	
	public void setName(String n)
	{ name = n; }
	
	public void displayStatistics()
	{
		System.out.print("Stats for this " + name + " : ");
		super.displayStatistics();
	}
}