package co.psebastian21.s4ncorrientazodelivery.droneoperation;

import org.junit.Test;

import org.junit.Assert;

public class HeadingSituationTests {
	
	@Test
	public void whenRotatingClockwiseOnceThenFacesEast() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateClockwise();
		//Assert
		Assert.assertEquals(HeadingValue.EAST, hs.getHeading());
	}
	@Test
	public void whenRotatingClockwiseTwiceThenFacesSouth() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateClockwise();
		hs.rotateClockwise();
		//Assert
		Assert.assertEquals(HeadingValue.SOUTH, hs.getHeading());
	}

	@Test
	public void whenRotatingClockwiseThreeTimesThenFacesWest() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateClockwise();
		hs.rotateClockwise();
		hs.rotateClockwise();
		//Assert
		Assert.assertEquals(HeadingValue.WEST, hs.getHeading());
	}

	@Test
	public void whenRotatingClockwiseFourTimesThenFacesNorth() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateClockwise();
		hs.rotateClockwise();
		hs.rotateClockwise();
		hs.rotateClockwise();
		//Assert
		Assert.assertEquals(HeadingValue.NORTH, hs.getHeading());
	}
	@Test
	public void whenRotatingCounterclockwiseOnceThenFacesWest() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateCounterclockwise();
		//Assert
		Assert.assertEquals(HeadingValue.WEST, hs.getHeading());
	}
	@Test
	public void whenRotatingCounterclockwiseTwiceThenFacesSouth() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		//Assert
		Assert.assertEquals(HeadingValue.SOUTH, hs.getHeading());
	}

	@Test
	public void whenRotatingCounterclockwiseThreeTimesThenFacesEast() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		//Assert
		Assert.assertEquals(HeadingValue.EAST, hs.getHeading());
	}

	@Test
	public void whenRotatingCounterclockwiseFourTimesThenFacesNorth() {
		//Arrange
		HeadingSituation hs = new HeadingSituation();
		//Act
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		hs.rotateCounterclockwise();
		//Assert
		Assert.assertEquals(HeadingValue.NORTH, hs.getHeading());
	}

}
