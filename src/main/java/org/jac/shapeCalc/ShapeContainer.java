package org.jac.shapeCalc;

import java.util.HashMap;
import java.util.Map;

public class ShapeContainer {

	private final Map<String,Shape> shapes = new HashMap<String, Shape>();
	public void add(String name, Shape shape) {
		shapes.put(name, shape);
	}

	public Shape get(String name) {
		
		return shapes.get(name);
	}

	public double totalPerimeter() {
		double sum=0;
		for (Shape shape : shapes.values()) {
			sum+=shape.perimeter();
		}
		return sum;
		
		//prima la trasformavo in un arrayList
		/*List<Shape> shapeList = new ArrayList<Shape>(shapes.values());
		for (Shape shape : shapeList) {
			sum+=shape.perimeter();
		}
		return sum;*/
		
		/**
		 * Reference: 
		 * https://www.geeksforgeeks.org/iterate-map-java/
		 */
	}

}
