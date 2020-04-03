package org.jac.shapeCalc;

public class Rectangle implements Shape, AreaCalculable, PerimeterCalculable {
	double width;
	double height;
	
	public Rectangle(double width, double height) {
		if(width<=0 || height<=0) {
			throw new IllegalArgumentException("no ai parametri negativi");
		}
		this.width=width;
		this.height=height;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (this.width + this.height) * 2;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return this.height*this.width;
	}

}
