package co.psebastian21.s4ncorrientazodelivery.droneoperation;

public class SpatialSituation {
	
	private Point location;
	private HeadingSituation heading;
	
	public SpatialSituation() {
		this.location = new Point();
		this.heading = new HeadingSituation();
	}
	
	public HeadingValue rotateClockwise() {
		return this.heading.rotateClockwise();
	}
	public HeadingValue rotateCounterclockwise() {
		return this.heading.rotateCounterclockwise();
	}
	public Point moveForward() {
		switch(this.heading.getHeading()) {
		case NORTH:
			this.location.addToY(1);
			break;
		case EAST:
			this.location.addToX(1);
			break;
		case SOUTH:
			this.location.addToY(-1);
			break;
			default:
				this.location.addToX(-1);
		}
		return this.location;
	}

}
