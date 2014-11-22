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
	
	protected boolean timeout(boolean v, int delay) {
		if (v) {
			Delay.msDelay(delay);
		}
		return v;
	}
	
	protected boolean timeout(boolean v) {
		return this.timeout(v, 3000);
	}
	
	public abstract String getTitle();
	public abstract boolean run();
}
