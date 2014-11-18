package zyy.ev3.mecanum.test;

import zyy.ev3.mecanum.MecanumNavigator;
import zyy.ev3.mecanum.RouteCircle;

public class MecaletCircle1 extends Mecalet {

	public MecaletCircle1(MecanumNavigator w) {
		super(w);
	}

	@Override
	public boolean run() {
		MecanumNavigator w = getMecanumNavigator();
		
		RouteCircle c = new RouteCircle();
		c.drawCoord();
		c.draw(45.0, true);
		double d = w.getWheel().angleToDistance(360.0 * 2);
		return w.pilot(c.getMap(d));
	}

	@Override
	public String getTitle() {
		return "Circle (1)";
	}

}
