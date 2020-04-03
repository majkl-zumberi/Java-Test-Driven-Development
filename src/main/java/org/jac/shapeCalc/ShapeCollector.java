package org.jac.shapeCalc;

import java.util.ArrayList;

public class ShapeCollector {

	 ArrayList<Shape> shapeContainer;
	 
	public ShapeCollector() {
		this.shapeContainer=new ArrayList<Shape>();
	}
	
	public void addShape(Shape shape) {
		if(shape == null)
			throw new IllegalArgumentException("Argomento non deve essere null");
		shapeContainer.add(shape);
	}

	public double getTotalPerimeter() {
		double sum=0;
		for (Shape shape : shapeContainer) {
			sum+=shape.perimeter();
		}
		return sum;
	}

}
