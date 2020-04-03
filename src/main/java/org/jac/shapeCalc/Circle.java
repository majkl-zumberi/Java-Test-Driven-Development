package org.jac.shapeCalc;

public class Circle implements Shape {

	private double radius;
	
	
	public Circle(double radius) {
		if(radius<=0) {
			throw new IllegalArgumentException("no ai parametri negativi");
		}
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*(Math.PI*radius);
	}

	@Override
	public double area() {
		return (Math.PI*(Math.pow(this.radius,2)));
	}

}
