package zyy.ev3.mecanum.test;

import lejos.utility.Delay;
import zyy.ev3.mecanum.MecanumNavigator;
import zyy.ev3.mecanum.RouteCircle;

public class MecaletCircle2 extends Mecalet {

	public MecaletCircle2(MecanumNavigator w) {
		super(w);
	}

	@Override
	public boolean run() {
		RouteCircle c = new RouteCircle();
		c.drawCoord();
		c.draw(45.0, true);
		
		MecanumNavigator w = getMecanumNavigator();
		int i;
		for (i = 0; i < 360; i += 5) {
			w.polar(90.0 + i);
			Delay.msDelay(500);
		}
		return true;
	}

	@Override
	public String getTitle() {
		return "Circle (2)";
	}

}
