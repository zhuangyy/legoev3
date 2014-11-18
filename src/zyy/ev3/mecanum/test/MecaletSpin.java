package zyy.ev3.mecanum.test;

import zyy.ev3.mecanum.MecanumNavigator;

public class MecaletSpin extends Mecalet {

	public MecaletSpin(MecanumNavigator w) {
		super(w);
	}

	@Override
	public String getTitle() {
		return "Spin Test";
	}

	@Override
	public boolean run() {
		MecanumNavigator w = getMecanumNavigator();
		timeout(w.spin(true));
		timeout(w.spin(false));
		return true;
	}

}
