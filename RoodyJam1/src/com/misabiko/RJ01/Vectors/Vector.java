package com.misabiko.RJ01.Vectors;

public class Vector {
	public double x, y;
	
	public Vector() {
		x = 0;
		y = 0;
	}
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector(double angle, double length) {
		super();
		setAngle(angle);
		setLength(length);
	}
	
	public double getAngle() {
		if (x <= 0) {
			if (y < 0) {
				return 360+Math.toDegrees(Math.atan2((double)y,(double)x));
			}
			else if (y == 0) {
				return 0;
			}
			else {
				return Math.toDegrees(Math.atan2((double)y,(double)x));
			}
		}
		else {
			if (y <= 0) {
				return 360+Math.toDegrees(Math.atan2((double)y,(double)x));
			}
			else {
				return Math.toDegrees(Math.atan2((double)y,(double)x));
			}
		}
	}
	
	public void setAngle(double angle){
		if (x == 0 && y == 0) {
			System.out.println("Can't set an angle to a vector if the length is 0");
		}else {
			double length = getLength();
			
			x = Math.cos(Math.toRadians(angle))*length;
			y = Math.sin(Math.toRadians(angle))*length;
		}
	}
	
	public double getLength() {
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	public void setLength(double length) {
		double absLength = Math.abs(length);	//I'm a little meh about negative lengths
		double angle = getAngle();
	
		x = Math.cos(Math.toRadians(angle))*absLength;
		y = Math.sin(Math.toRadians(angle))*absLength;
		
		if (length < 0)
			mirror();
	}
	
	public String toString() {
		return "X: "+x+" Y: "+y+" Angle: "+getAngle()+" Length: "+getLength();
	}
	
	public void mirror() {
		mirrorX();
		mirrorY();
	}
	
	public void mirrorX() {
		x = -x;
	}
	
	public void mirrorY() {
		y = -y;
	}
	
	public void add(Vector v) {
		x += v.x;
		y += v.y;
	}
	
	public void mult(double scalar) {
		setLength(getLength()*scalar);
	}
}
