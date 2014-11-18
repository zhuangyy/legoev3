package zyy.ev3.mecanum;

import java.util.ArrayList;
import java.util.Iterator;

import lejos.robotics.geometry.Point;
import lejos.utility.Delay;

public class RouteCircle extends Route {
	
	public RouteCircle() {
	}
		
	public void draw(double radius, boolean animate) {
		ArrayList<Point> map = getMap(radius);
		Iterator<Point> i = map.iterator();
		while (i.hasNext()) {
			Point p = i.next();
			int x = round(p.getX());
			int y = round(p.getY());
			drawPixel(x, y);
			if (animate) {
				Delay.msDelay(20);
			}			
		}
	}
	
	public ArrayList<Point> getMap(double radius) {
		ArrayList<Point> r = new ArrayList<Point>();
		int i;
		for (i = 0; i < 360; i += 5) {
			double d = Math.toRadians(i);
			Point p = new Point((float)(Math.sin(d) * radius), (float)(Math.cos(d) * radius));
			r.add(p);
		}
		return r;
	}
}
