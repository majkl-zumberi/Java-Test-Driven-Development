package org.jac.shapeCalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

	private Shape rectangle;

	@Before
	public void buildRect() {
		Shape rectangle = new Rectangle(3.0, 4.0);
		this.rectangle = rectangle;
	}

	@Test
	public void PerimeterTest() {
		double rectPerimeter = rectangle.perimeter();
		assertEquals(14, rectPerimeter, 0);
	}

	@Test
	public void AreaTest() {
		double rectArea = rectangle.area();
		assertEquals(12, rectArea, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void negativeParameterRect() {
		new Rectangle(-5.0, 9);
	}

}
