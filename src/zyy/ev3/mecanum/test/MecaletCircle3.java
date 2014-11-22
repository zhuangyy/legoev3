package zyy.ev3.mecanum.test;

import zyy.ev3.mecanum.MecanumNavigator;
import zyy.ev3.mecanum.MecanumWheel;

public class MecaletCircle3 extends Mecalet {

	public MecaletCircle3(MecanumNavigator w) {
		super(w);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitle() {
		return "Circle (3)";
	}

	@Override
	public boolean run() {
		double speed[] = new double[4];
		speed[MecanumWheel.FL] = -1.0;
		speed[MecanumWheel.FR] = 1.0;
		speed[MecanumWheel.BL] = -2.0;
		speed[MecanumWheel.BR] = 2.0;
		
		MecanumNavigator w = getMecanumNavigator();
		double o = w.getWheel().setMaxSpeed(600.0);
		timeout(w.drive(speed, true), 16000);
		w.getWheel().setMaxSpeed(o);
		return true;
	}

}
