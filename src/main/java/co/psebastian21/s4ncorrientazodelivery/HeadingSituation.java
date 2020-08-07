package co.psebastian21.s4ncorrientazodelivery;

public class HeadingSituation {
	
	private Heading heading;
	
	public HeadingSituation() {
		Heading northHeading = new Heading(HeadingValue.NORTH);
		Heading eastHeading = new Heading(HeadingValue.EAST);
		Heading westhHeading = new Heading(HeadingValue.WEST);
		Heading southHeading = new Heading(HeadingValue.SOUTH);
		northHeading.nextClockwise = eastHeading;
		northHeading.nextCounterclockwise = westhHeading;
		eastHeading.nextClockwise = southHeading;
		eastHeading.nextCounterclockwise = northHeading;
		southHeading.nextClockwise = westhHeading;
		southHeading.nextCounterclockwise = eastHeading;
		this.heading = northHeading;
	}
	
	public void rotateClockwise() {
		this.heading = this.heading.nextClockwise;
	}
	public void rotateCounterclockwise() {
		this.heading = this.heading.nextCounterclockwise;
	}
	public HeadingValue getHeading() {
		return this.heading.headingValue;
	}
	
	private class Heading{
		private Heading nextClockwise;
		private Heading nextCounterclockwise;
		private HeadingValue headingValue;
		
		private Heading(HeadingValue headingValue) {
			this.headingValue = headingValue;
		}
	}

}
