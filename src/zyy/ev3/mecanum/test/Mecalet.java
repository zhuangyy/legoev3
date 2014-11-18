package zyy.ev3.mecanum.test;

import lejos.utility.Delay;
import zyy.ev3.mecanum.MecanumNavigator;

public abstract class Mecalet {
	protected MecanumNavigator navigator;
	
	public Mecalet(MecanumNavigator w) {
		navigator = w;
	}
	
	protected MecanumNavigator getMecanumNavigator() {
		return navigator;
	}
	
	protected boolean timeout(boolean v) {
		if (v) {
			Delay.msDelay(3000);
		}
		return v;
	}
	
	public abstract String getTitle();
	public abstract boolean run();
}
