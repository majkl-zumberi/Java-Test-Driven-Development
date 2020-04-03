package org.jac.shapeCalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class shapeCalculatorTest {

	private Shape rectangle;
	private ShapeCalculator shapeCalc;
	private Shape circle;
	private Shape hexagon;

	/**
	 * preparazione ambiente
	 */
	@Before
	public void initTest() {
		ShapeCalculator shapeCalc = new ShapeCalculator();
		this.shapeCalc = shapeCalc;

		Shape rectangle = new Rectangle(3.0, 4.0);
		this.rectangle = rectangle;

		Shape circle = new Circle(5.0);
		this.circle = circle;

		Shape hexagon = new Hexagon(7.0);
		this.hexagon = hexagon;
	}

	@Test
	public void areaRectTest() {
		assertEquals(12, shapeCalc.area(rectangle), 0);
	}

	@Test
	public void perimeterRectTest() {
		assertEquals(14, shapeCalc.perimeter(rectangle), 0);
	}

	@Test
	public void areaCircleTest() {
		assertEquals(78.53, shapeCalc.area(circle), 0.01);
	}

	@Test
	public void PerimeterCircleTest() {
		assertEquals(31.41, shapeCalc.perimeter(circle), 0.01);

	}

	@Test
	public void areaExagonTest() {
		assertEquals(127.30, shapeCalc.area(hexagon), 0.1);
	}

	@Test
	public void perimeterExagonTest() {
		assertEquals(42, shapeCalc.perimeter(hexagon), 0.1);
	}

	@Test(expected = ArithmeticException.class)
	public void negativeSideExagon() {
		new Hexagon(-9);
	}

	/**
	 * sto iniettando una vera e propria espressione tramite lambda expression
	 * interfaccia funzionale
	 */
	@Test
	public void negativeLambdaSideHexagon() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> new Hexagon(-7));
		assertEquals("il lato deve essere > di 0", exception.getMessage());
	}

	/**
	 * sintassi equivalente al metodo precedente infatti se fai command + 1 puoi
	 * convertire un lambda expression
	 */

	@Test
	public void negativeInnerSideHexagon() {
		ArithmeticException exception = assertThrows(ArithmeticException.class, new ThrowingRunnable() {
			@Override
			public void run() throws Throwable {
				new Hexagon(-7);
			}
		});
		assertEquals("il lato deve essere > di 0", exception.getMessage());
	}

	/**
	 * test con anonymous inner class non scegliere anonymous inner class awt mock
	 * (object) dell'interfaccia shape visto che shape ha 2 metodi non è un'
	 * interfaccia funzionale non convertibile in lambda expression
	 */
	@Test
	public void anonymousShapeTest() {
		Shape shape = new Shape() {

			@Override
			public double perimeter() {
				return 5;
			}

			@Override
			public double area() {
				return 15;
			}
		};
		double perimeter = shapeCalc.perimeter(shape);
		double area = shapeCalc.area(shape);
		assertEquals(5, perimeter, 0);
		assertEquals(15, area, 0);

	}

	@Test
	public void areaWIthInterfaceTest() {
		AreaCalculable areaCalculable = new Rectangle(3, 4);
		double area = shapeCalc.area(areaCalculable);
		assertEquals(12, area, 0);
	}

	@Test
	public void perimeterWIthInterfaceTest() {
		PerimeterCalculable perimeterCalculable = new Rectangle(3, 4);
		double perimeter = shapeCalc.perimeter(perimeterCalculable);
		assertEquals(14, perimeter, 0);
	}

	@Test
	public void innerTest() {
		double perimeter = shapeCalc.perimeter(new PerimeterCalculable() {

			@Override
			public double perimeter() {
				return 5;
			}

		});
		assertEquals(5, perimeter, 0);
		
		double area = shapeCalc.area(new AreaCalculable() {

			@Override
			public double area() {
				return 15;
			}

		});
		assertEquals(15, area, 0);

	}

	/**
	 * interfaccia funzionale
	 * uguale al test precedente
	 */
	@Test
	public void lambdaTest() {
		PerimeterCalculable perimeterCalculable = () -> 5;
		AreaCalculable areaCalculable = () -> 15;
		double perimeter = shapeCalc.perimeter(perimeterCalculable);
		double area = shapeCalc.area(areaCalculable);
		assertEquals(5, perimeter, 0);
		assertEquals(15, area, 0);

	}
	
	@Test 
	public void sumPerimeterTest() {
		
		Shape rectangle2 = new Rectangle(4.0, 4.0);
		Shape genericShape = new Shape() {
			
			@Override
			public double perimeter() {
				// TODO Auto-generated method stub
				return 15;
			}
			
			@Override
			public double area() {
				// TODO Auto-generated method stub
				return 20;
			}
		};
		
		
		ShapeCollector shapeCollector = new ShapeCollector();
		shapeCollector.addShape(rectangle);
		shapeCollector.addShape(rectangle2);
		shapeCollector.addShape(genericShape);
		double totalPerimeter=shapeCollector.getTotalPerimeter();
		assertEquals(45,totalPerimeter,0);
	}
	
	/**
	 * test ShapeContainer con shape a null
	 * test con lambda expression
	 */
	@Test
	public void ExceptionSumPerimeterTest() {
		ShapeCollector shapeContainer = new ShapeCollector();
	 
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->shapeContainer.addShape(null));
		assertEquals("Argomento non deve essere null",exception.getMessage());
	}

}
