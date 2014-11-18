package zyy.ev3.mecanum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.lcd.LCD;
import lejos.robotics.geometry.Point;
import lejos.utility.Delay;

public class Meca4x4 {
		
	static int DELAY = 3000;
	static MecanumNavigator wheels = new MecanumNavigator();
	
	private static void runx(boolean v) {
		if (v) {
			Delay.msDelay(DELAY);
		}
		//wheels.stop();
	}
	
	public static void test1() {
		//runx(wheels.polar(30.0, MAXSPEED));
		//runx(wheels.polar(60.0, MAXSPEED));
		if (true) {
			runx(wheels.polar(270.0));
			runx(wheels.polar(0.0));
			runx(wheels.polar(90.0));
			runx(wheels.polar(180.0));
			runx(wheels.rotate(true));
	        runx(wheels.rotate(false));		
		}
		wheels.stop(false);
		
		if (true) {
			double d = wheels.getWheel().angleToDistance(360.0 * 3);
			wheels.polar(315.0, d);
			wheels.polar(225.0, d);
			wheels.polar(135.0, d);
			wheels.polar(45.0, d);
		}
		//runx(wheels.polar(135.0));
		//runx(wheels.polar(45.0));
		//runx(wheels.polar(225.0));
		//runx(wheels.polar(315.0));
	}
	
	public static void test2() {
		List<Point> l = new ArrayList<Point>();
		l.add(new Point(-1, 0));
		l.add(new Point(-1, 1));
		l.add(new Point(0, 1));
		//l.add(new Point(-1, 1));
		l.add(new Point(0, 0));
		Iterator<Point> it = l.iterator();
		Point from = new Point(0, 0);
		while (it.hasNext()) {
			Point to = it.next();
			//runx(wheels.cartesian(from, to, 150));
			wheels.cartesian(from, to, wheels.getWheel().angleToDistance(360.0 * 3));
			from.moveTo(to);
		}
	}
	
	public static void test3() {
		//RouteCircle c = new RouteCircle();
		RouteHeart c = new RouteHeart();
		c.drawCoord();
		c.draw(5.0, true);
		Delay.msDelay(5000);
	}
	
	public static void test4() {
		RouteCircle c = new RouteCircle();
		c.drawCoord();
		c.draw(45.0, true);
		double d = wheels.getWheel().angleToDistance(360.0 * 2);
		wheels.pilot(c.getMap(d));
	}
	
	public static void test5() {
		RouteCircle c = new RouteCircle();
		c.drawCoord();
		c.draw(45.0, true);
		Delay.msDelay(3000);
		int i;
		for (i = 0; i < 360; i += 5) {
			wheels.polar(90.0 + i);
			Delay.msDelay(500);
		}
	}
	
	public static void run() {
		//test2();
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LCD.drawString("Plugin Test", 0, 4);
		//Delay.msDelay(5000);
		
		//Meca4x4 x = new Meca4x4();
		//x.start();
		run();
		//Button.waitForAnyPress();
		//x.interrupt();
		
		wheels.stop();
		wheels.release();
	}

}

