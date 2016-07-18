package pl.akademiakodu.bouncing;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Ball implements Movable {

	private double x = 0;
	private double y = 0;
	private double deltaX = 1;
	private double deltaY = 1;
	private static final int radius = 15;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDeltaX() {
		return deltaX;
	}

	public void setDeltaX(double deltaX) {
		this.deltaX = deltaX;
	}

	public double getDeltaY() {
		return deltaY;
	}

	public void setDeltaY(double deltaY) {
		this.deltaY = deltaY;
	}

	public static int getRadius() {
		return radius;
	}

	//@Override
	public void move(Rectangle2D bounds) {
		x += deltaX;
		y += deltaY;
		if (x <= bounds.getMinX()) {
			x = bounds.getMinX();
			deltaX = -deltaX;
		}
		if (y <= bounds.getMinY()) {
			y = bounds.getMinY();
			deltaY = -deltaY;
		}

		if (x + radius >= bounds.getMaxX()) {
			x = bounds.getMaxX() - radius;
			deltaX = -deltaX;
		}
		if (y + radius >= bounds.getMaxY()) {
			y = bounds.getMaxY() - radius;
			deltaY = -deltaY;
		}
	}

	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, radius, radius);
	}

}
