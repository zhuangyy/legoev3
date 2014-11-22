package zyy.ev3.mecanum.test;

import zyy.ev3.mecanum.MecanumNavigator;
import zyy.ev3.mecanum.MecanumWheel;
import lejos.utility.TextMenu;

public class Meca4x4 {
		
	static MecanumNavigator nav = new MecanumNavigator(new MecanumWheel(40.0, 300.0));
	static Mecalets lets = new Mecalets(nav);
			
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextMenu menu = new TextMenu(lets.getTitles());
		int r = menu.select();
		while (r >= 0) {
			if (lets.run(r)) {
				nav.stop(false);			
			}
			r = menu.select();
		}
		nav.release();
	}

}

