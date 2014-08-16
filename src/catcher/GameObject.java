package catcher;

import java.awt.Graphics2D;

public abstract class GameObject {

	private double x, y;
	private double vx, vy;
	private double width, height;
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double value) {
		x = value;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double value) {
		y = value;
	}
	
	public double getVx() {
		return vx;
	}
	
	public void setVx(double value) {
		vx = value;
	}
	
	public double getVy() {
		return vy;
	}
	
	public void setVy(double value) {
		vy = value;
	}
	
	public void update() {
		setX(getX() + getVx());
		setY(getY() + getVy());
	}
	
	public boolean doesCollide(GameObject obj) {
		return (getX() <= obj.getX() + obj.getWidth() &&
				getX() + getWidth() >= obj.getX() &&
				getY() <= obj.getY() + obj.getHeight() &&
				getY() + getHeight() >= obj.getY());
	}
	
	public abstract void draw(Graphics2D g, long gameFrame);
	
	public void onCollide(GameObject obj) {}
	
}
