package zyy.ev3.mecanum;

import lejos.robotics.geometry.Point;

public abstract class MecanumWheel {
	public static final int FL = 0;
	public static final int FR = 1;
	public static final int BL = 2;
	public static final int BR = 3;
		
	public int distanceToAngle(double distance) {
		double r = (distance / (getRadius() * Math.PI)) * 180.0;
		return (int)Math.round(r);
	}
	
	public double angleToDistance(double degree) {
		return getRadius() * Math.PI * (degree / 180.0);
	}
	
	public double[] polar(double degree, double magnitude) {
		//double dirInRad = (degree + 45.0) * Math.PI / 180.0;
		double dirInRad = Math.toRadians(degree + 45.0);
		double cosD = Math.cos(dirInRad);
		double sinD = Math.sin(dirInRad);
		
		//magnitude = magnitude * Math.sqrt(2.0);
		double scale = 1000.0;
		double r[] = new double[4];
		r[FL] = Math.round(sinD * scale) / scale;
		r[FR] = Math.round(cosD * scale) / scale;
		r[BL] = Math.round(cosD * scale) / scale;
		r[BR] = Math.round(sinD * scale) / scale;
		
		//System.out.println(r[FL] + " " + r[FR] + " " + r[BL] + " " + r[BR]);
		return Util.proportion(r, Math.abs(magnitude));
	}
		
	public double[] cartesian(Point from, Point to) {
		double degree = 90.0 - from.angleTo(to);
		double magnitude = from.distance(to);
		return polar(degree, magnitude);
	}

	public abstract double getRadius();
	public abstract double getMaxSpeed();
}
