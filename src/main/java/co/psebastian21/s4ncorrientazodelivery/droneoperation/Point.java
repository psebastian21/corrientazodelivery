package co.psebastian21.s4ncorrientazodelivery.droneoperation;

public class Point {
	
	private int x;
	private int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void addToX(int x) {
		this.x += x;
	}
	void addToY(int y) {
		this.y += y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
