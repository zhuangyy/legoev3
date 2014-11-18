package zyy.ev3.mecanum;

import java.util.ArrayList;
import java.util.Iterator;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.geometry.Point;

public class MecanumNavigator {
	
	private RegulatedMotor[] motors;
	private MecanumWheel wheel;
	
	public MecanumNavigator() {
		this(new MecanumWheel40());
	}
	
	public MecanumNavigator(MecanumWheel w) {
		// FL, FR, BL, BR
		String x[] = { "C", "D", "B", "A" };
		int i;
		
		Brick ev3 = BrickFinder.getDefault();
		ev3.setDefault();
		motors = new RegulatedMotor[4];
		for (i = 0; i < motors.length; i ++) {
			motors[i] = new EV3LargeRegulatedMotor(ev3.getPort(x[i]));
			//motors[i] = new NXTRegulatedMotor(ev3.getPort(x[i]));
		}
		wheel = w;
	}
	
	public MecanumWheel getWheel() {
		return wheel;
	}
	
	private void invert(double[] x) {
		x[MecanumWheel.BL] *= -1.0;
		x[MecanumWheel.BR] *= -1.0;
	}
	
	private void setMotorSpeed(double[] x) {
		double[] y = Util.proportion(x, wheel.getMaxSpeed());
		int[] s = Util.round(y);
		int i;
		for (i = 0; i < motors.length; i ++) {
			int v = Math.abs(s[i]);
			motors[i].setSpeed(v);
			//motors[i].setAcceleration(v * 2);
		}
	}
	
	private boolean drive(double[] x, boolean unlimit) {
		int i;
		
		setMotorSpeed(x);
		invert(x);
		for (i = 0; i < motors.length; i ++) {
			if (x[i] > 0) {
				if (unlimit) {
					motors[i].forward();
				}
				else {
					motors[i].rotate(wheel.distanceToAngle(x[i]), true);
				}
				continue;
			}
			if (x[i] < 0) {
				if (unlimit) {
					motors[i].backward();
				}
				else {
					motors[i].rotate(wheel.distanceToAngle(x[i]), true);					
				}
				continue;
			}
			motors[i].stop(true);
		}
		if (!unlimit) {
			for (i = 0; i < motors.length; i ++) {
				motors[i].waitComplete();
			}
		}
		return true;
	}
	
	public boolean polar(double degree) {
		return polar(degree, -1.0);
	}
	
	public boolean polar(double degree, double distance) {
		double[] x = wheel.polar(degree, distance);
		return drive(x, (distance < 0.0) ? true : false);
	}
	
	public boolean cartesian(Point from, Point to) {
		return cartesian(from, to, 0.0);
	}

	public boolean cartesian(Point from, Point to, double scale) {
		double[] x = wheel.cartesian(from, to);
		if (scale > 0.0) {
			x = Util.proportion(x, scale);
		}
		return drive(x, false);
	}
	
	public boolean pilot(ArrayList<Point> map) {
		Iterator<Point> i = map.iterator();
		Point from = new Point(0, 0);
		while (i.hasNext()) {
			Point to = i.next();
			cartesian(from, to);
			from.moveTo(to);
		}
		return true;
	}
	
	public boolean spin(boolean clockwise) {
		double x[] = new double[4];
		double maxspeed = wheel.getMaxSpeed();
		if (clockwise) {
			x[MecanumWheel.FL] = x[MecanumWheel.BL] = maxspeed;
			x[MecanumWheel.FR] = x[MecanumWheel.BR] = 0 - maxspeed;
		}
		else {
			x[MecanumWheel.FL] = x[MecanumWheel.BL] = 0 - maxspeed;
			x[MecanumWheel.FR] = x[MecanumWheel.BR] = maxspeed;
		}
		return drive(x, true);
	}
	
	public void stop(boolean immediat) {
		int i;	
		for (i = 0; i < motors.length; i ++) {
			motors[i].stop(immediat);
		}
	}

	public void stop() {
		stop(true);
	}

	public void release() {
		int i;	
		for (i = 0; i < motors.length; i ++) {
			motors[i].close();
		}
	}
	
	public double getMaxSpeed() {
		return motors[0].getMaxSpeed();
	}

}
