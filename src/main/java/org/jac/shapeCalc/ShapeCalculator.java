package org.jac.shapeCalc;

public class ShapeCalculator {
	/**
	 * 
	 * @param shape
	 * dependence injection
	 * inietto dipendenza @param shape (interfaccia)
	 */
	public double area(Shape shape) {
		return shape.area();
	}
	public double perimeter(Shape shape) {
		return shape.perimeter();
	}
	
	public double area(AreaCalculable areaCalc) {
		return areaCalc.area();
	}
	public double perimeter(PerimeterCalculable perimeterCalc) {
		return perimeterCalc.perimeter();
	}
}
