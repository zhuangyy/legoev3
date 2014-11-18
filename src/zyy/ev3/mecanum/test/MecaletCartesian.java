package zyy.ev3.mecanum.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lejos.robotics.geometry.Point;
import zyy.ev3.mecanum.MecanumNavigator;

public class MecaletCartesian extends Mecalet {

	public MecaletCartesian(MecanumNavigator w) {
		super(w);
	}

	@Override
	public boolean run() {
		List<Point> l = new ArrayList<Point>();
		l.add(new Point(-1, 0));
		l.add(new Point(-1, 1));
		l.add(new Point(0, 1));
		l.add(new Point(0, 0));
		
		Iterator<Point> it = l.iterator();
		Point from = new Point(0, 0);
		MecanumNavigator w = getMecanumNavigator();
		double d = w.getWheel().angleToDistance(360.0 * 3);
		while (it.hasNext()) {
			Point to = it.next();
			w.cartesian(from, to, d);
			from.moveTo(to);
		}
		return true;
	}

	@Override
	public String getTitle() {
		return "Cartesian Test";
	}

}
