package org.jac.shapeCalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircleTest {

	private Shape circle;
	
	@Before 
	public void buildCircle() {
		Shape circle =new Circle(5.0);
		this.circle=circle;
	}
	
	@Test
	public void PerimeterTest() {
		double circlePerimeter = circle.perimeter();
		assertEquals(31.41,circlePerimeter,0.01);
	}

	@Test
	public void AreaTest() {
		double circleArea = circle.area();
		assertEquals(78.53,circleArea,0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negativeParameterCircle() {
		new Circle(-5.0);
	}
	
	
}
