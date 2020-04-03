package org.jac.shapeCalc;

public class Hexagon implements Shape {

	protected double side;
	
	public Hexagon(double side) {
		if(side <=0)
			throw new ArithmeticException("il lato deve essere > di 0");
		this.side = side;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return (this.area()*2)/(this.side*0.866);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (this.side*(this.side*0.866)/2)*6;
	}

}
