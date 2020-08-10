package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import org.junit.Test;

import org.junit.Assert;

public class SpatialSituationTests {
	@Test
	public void whenFacingNorthAndMovingForwardThenYIsIncremented() {
		//Arrange
		SpatialSituation ss = new SpatialSituation();
		//Act
		ss.moveForward();
		//Assert
		Assert.assertEquals(HeadingValue.NORTH, ss.getHeading());
		Assert.assertEquals(1, ss.getLocation().getY());
	}
	@Test
	public void whenFacingEastAndMovingForwardThenXIsIncremented() {
		//Arrange
		SpatialSituation ss = new SpatialSituation();
		//Act
		ss.rotateClockwise();
		ss.moveForward();
		//Assert
		Assert.assertEquals(HeadingValue.EAST, ss.getHeading());
		Assert.assertEquals(1, ss.getLocation().getX());
	}
	@Test
	public void whenFacingSouthAndMovingForwardThenYIsDecremented() {
		//Arrange
		SpatialSituation ss = new SpatialSituation();
		//Act
		ss.rotateClockwise();
		ss.rotateClockwise();
		ss.moveForward();
		//Assert
		Assert.assertEquals(HeadingValue.SOUTH, ss.getHeading());
		Assert.assertEquals(-1, ss.getLocation().getY());
	}
	@Test
	public void whenFacingWesthAndMovingForwardThenXIsDecremented() {
		//Arrange
		SpatialSituation ss = new SpatialSituation();
		//Act
		ss.rotateCounterclockwise();
		ss.moveForward();
		//Assert
		Assert.assertEquals(HeadingValue.WEST, ss.getHeading());
		Assert.assertEquals(-1, ss.getLocation().getX());
	}
	@Test
	public void whenGettingHomeThenLocationIsInOrigin() {
		//Arrange
		SpatialSituation ss = new SpatialSituation();
		//Act
		ss.moveForward();
		ss.rotateClockwise();
		ss.moveForward();
		ss.getHome();
		//Assert
		Assert.assertEquals(0, ss.getLocation().getX());
		Assert.assertEquals(0, ss.getLocation().getY());
	}
}
