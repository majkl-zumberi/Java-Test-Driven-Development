package org.jac.shapeCalc;

import static org.junit.Assert.*;

import org.junit.Test;

public class shapeContainerTest {

	@Test
	public void test() {
		Shape rectangle = new Rectangle(3.0, 4.0);
		Shape rectangle2 = new Rectangle(5.0, 5.0);
		ShapeContainer shapeContainer = new ShapeContainer();
		shapeContainer.add("rettangolo1",rectangle);
		shapeContainer.add("rettangolo2",rectangle2);
		
		Shape actual =shapeContainer.get("rettangolo1");
		double area= actual.area();
		assertEquals(12,area,0);
		double totalPerimeter= shapeContainer.totalPerimeter();
		assertEquals(34,totalPerimeter,0);
	}

}
