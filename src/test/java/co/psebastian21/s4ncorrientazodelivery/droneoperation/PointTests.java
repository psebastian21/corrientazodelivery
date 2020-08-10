package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import org.junit.Test;

import org.junit.Assert;

public class PointTests {
	
	@Test
	public void whenAddingToXThenPointIsDisplaced() {
		//Arrange
		Point p = new Point(10, 0);
		//Act
		p.addToX(8);
		//Assert
		Assert.assertEquals(18, p.getX());
	}
	@Test
	public void whenSubtractingToXThenPointIsDisplaced() {
		//Arrange
		Point p = new Point(10, 0);
		//Act
		p.addToX(-8);
		//Assert
		Assert.assertEquals(2, p.getX());
	}
	@Test
	public void whenAddingToYThenPointIsDisplaced() {
		//Arrange
		Point p = new Point();
		//Act
		p.addToY(14);
		//Assert
		Assert.assertEquals(14, p.getY());
	}
	@Test
	public void whenSubtractingToYThenPointIsDisplaced() {
		//Arrange
		Point p = new Point(0, 2);
		//Act
		p.addToY(-20);
		//Assert
		Assert.assertEquals(-18, p.getY());
	}

}
