package zyy.ev3.mecanum.test;

import zyy.ev3.mecanum.MecanumNavigator;

public class MecaletPolar extends Mecalet {
	
	public MecaletPolar(MecanumNavigator w) {
		super(w);
	}
	
	@Override
	public boolean run() {
		MecanumNavigator w = getMecanumNavigator();
		double d = w.getWheel().angleToDistance(360.0 * 3);
		w.polar(0.0, d);
		w.polar(270.0, d);
		w.polar(180.0, d);
		w.polar(90.0, d);
		w.polar(315.0, d);
		w.polar(225.0, d);
		w.polar(135.0, d);
		w.polar(45.0, d);
		
		return true;
	}

	@Override
	public String getTitle() {
		return "Polar Test";
	}

}
